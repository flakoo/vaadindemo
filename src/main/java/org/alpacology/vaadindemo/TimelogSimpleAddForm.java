package org.alpacology.vaadindemo;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.validator.DoubleRangeValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.alpacology.vaadindemo.category.Category;
import org.alpacology.vaadindemo.project.Project;
import org.alpacology.vaadindemo.timelog.TimelogEntry;
import org.alpacology.vaadindemo.timelog.TimelogEntryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Random;

@SpringComponent
@UIScope
public class TimelogSimpleAddForm extends FormLayout implements View {

    @Autowired
    private TimelogEntryService timelogEntryService;

    private Binder<TimelogEntry> binder = new Binder<>();

    @PostConstruct
    public void initForm() {
        addComponent(getSaveButton());
        addComponent(getHourCountInput(binder));
    }

    public TextField getHourCountInput(Binder<TimelogEntry> binder) {
        TextField hourCountField = new TextField("Hours");
        bind(binder, hourCountField);
        return hourCountField;
    }


    private Button getSaveButton() {
        return new Button("Save",
            event -> {
                try {
                    saveEntry();
                    UI.getCurrent().getNavigator().navigateTo("list");
                    Notification.show("Saved", Notification.Type.HUMANIZED_MESSAGE);
                } catch (ValidationException e) {
                    binder.validate();
                    Notification.show("Errors in form", Notification.Type.ERROR_MESSAGE);
                }
            });
    }

    private void saveEntry() throws ValidationException {
        TimelogEntry timelogEntry = getPrefilledEntry();

        binder.writeBean(timelogEntry);
        timelogEntryService.saveTimelogEntry(timelogEntry);

        Notification.show("Saved", Notification.Type.HUMANIZED_MESSAGE);
    }

    private TimelogEntry getPrefilledEntry() {
        return TimelogEntry.builder()
                    .day(LocalDate.now())
                    .id(100 + new Random().nextInt())
                    .category(Category.builder()
                            .id(1)
                            .name("Development")
                            .build())
                    .project(Project.builder()
                            .id(19)
                            .name("Not Touch")
                            .build())
                    .build();
    }

    public Binder.Binding<TimelogEntry, Double> bind(Binder<TimelogEntry> binder, TextField hourCountInput) {
        DoubleRangeValidator hourValidator = new DoubleRangeValidator("Number of hours has to be positive", 0.0, null);
        hourValidator.setMinValueIncluded(false);

        return binder.forField(hourCountInput)
                .asRequired("Enter number of hours spent")
                .withConverter(new StringToDoubleConverter("Invalid hour number"))
                .withValidator(hourValidator)
                .bind(
                        TimelogEntry::getHourCount,
                        TimelogEntry::setHourCount
                );
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}

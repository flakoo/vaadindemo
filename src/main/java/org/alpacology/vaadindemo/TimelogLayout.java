package org.alpacology.vaadindemo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.alpacology.vaadindemo.timelog.TimelogEntryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent
@UIScope
public class TimelogLayout extends HorizontalLayout implements View {

    @Autowired
    private TimelogGrid timelogGrid;

    @Autowired
    private TimelogEntryService timelogEntryService;

    @PostConstruct
    public void init() {
        addComponent(timelogGrid);
        addComponent(getSummaryLayout());

        setSizeFull();
    }

    private VerticalLayout getSummaryLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(new Label("Total hours spent: " + timelogEntryService.getTotalSpentTime()));
        verticalLayout.addComponents(configureCreateButton());
        return verticalLayout;
    }

    private Button configureCreateButton() {
        Button button = new Button("Add entry");
        button.addClickListener(event -> UI.getCurrent().getNavigator().navigateTo("add"));

        return button;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        timelogGrid.updateList();
    }
}

package org.alpacology.vaadindemo;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.alpacology.vaadindemo.timelog.TimelogEntryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent
@UIScope
public class TimelogLayout extends HorizontalLayout {

    @Autowired
    private TimelogGrid timelogGrid;

    @Autowired
    private TimelogEntryService timelogEntryService;

    @PostConstruct
    public void init() {
        addComponent(timelogGrid);
        addComponent(
                new Label("Total hours spent: " + timelogEntryService.getTotalSpentTime())
        );

        setSizeFull();
    }
}

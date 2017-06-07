package org.alpacology.vaadindemo;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.alpacology.vaadindemo.timelog.TimelogEntry;
import org.alpacology.vaadindemo.timelog.TimelogEntryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent // Not to be confused with Vaadin's Component!
@UIScope // separate instances per view
public class TimelogGrid extends Grid<TimelogEntry> {

    @Autowired
    private TimelogEntryService timelogEntryService;

    @PostConstruct
    public void initGrid() {
        updateList();

        addColumn(TimelogEntry::getHourCount)
                .setCaption("Hours spent");
        addColumn(TimelogEntry::getDay)
                .setCaption("When");
        addColumn(entry -> entry.getProject().getName())
                .setCaption("Project");
        addColumn(entry -> entry.getCategory().getName())
                .setCaption("Task category");

        setSizeFull();
    }

    public void updateList() {
        setItems(timelogEntryService.getTimelogEntriesAsList());
    }
}

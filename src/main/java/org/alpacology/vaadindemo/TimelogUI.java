package org.alpacology.vaadindemo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import org.alpacology.vaadindemo.timelog.TimelogEntry;
import org.alpacology.vaadindemo.timelog.TimelogEntryService;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class TimelogUI extends UI {

    @Autowired
    private TimelogEntryService timelogEntryService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.setSizeFull();

        Grid<TimelogEntry> grid = new Grid<>(TimelogEntry.class);
        grid.setItems(timelogEntryService.getTimelogEntriesAsList());
        grid.setColumns("hourCount", "day", "project", "category");
        grid.setSizeFull();

        setContent(grid);
    }

}

package org.alpacology.vaadindemo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class TimelogUI extends UI {

    @Autowired
    private TimelogLayout timelogLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.setSizeFull();

        setContent(timelogLayout);
    }
}

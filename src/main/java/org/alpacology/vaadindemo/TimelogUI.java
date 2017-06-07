package org.alpacology.vaadindemo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
public class TimelogUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.setSizeFull();
    }

}

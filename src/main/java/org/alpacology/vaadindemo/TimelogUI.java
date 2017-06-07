package org.alpacology.vaadindemo;

import com.vaadin.annotations.Viewport;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringUI
@Viewport("initial-scale=1, maximum-scale=1")
public class TimelogUI extends UI {

    @Autowired
    private TimelogLayout timelogLayout;

    @Autowired
    private TimelogSimpleAddForm timelogSimpleAddForm;

    private Navigator navigator;

    @PostConstruct
    public void initializeNavigator() {
        Responsive.makeResponsive(this);

        navigator = new Navigator(this, this);
        navigator.addView("", timelogLayout);
        navigator.addView("list", timelogLayout);
        navigator.addView("add", timelogSimpleAddForm);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.setSizeFull();

        setContent(timelogLayout);
    }
}

package com.javaguru.shoppinglist.console.Menu;

import org.springframework.stereotype.Component;

@Component
public class ExitMenuItem implements MenuItems {

    private static final String MENUITEM_NAME = "Exit";

    @Override
    public void execute() {

        System.exit(0);
    }

    @Override
    public String toString() {

        return MENUITEM_NAME;
    }

}

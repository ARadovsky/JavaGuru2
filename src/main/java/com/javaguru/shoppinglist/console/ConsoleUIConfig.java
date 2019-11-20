package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.Menu.MenuItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
public class ConsoleUIConfig {

    private final MenuItems addProductMenuItem;
    private final MenuItems findProductByIdMenuItem;
    private final MenuItems exitMenuItem;

    @Autowired
    public ConsoleUIConfig(MenuItems addProductMenuItem,
                           MenuItems findProductByIdMenuItem,
                           MenuItems exitMenuItem) {
        this.addProductMenuItem = addProductMenuItem;
        this.findProductByIdMenuItem = findProductByIdMenuItem;
        this.exitMenuItem = exitMenuItem;
    }

    @Bean
    ConsoleUI consoleUI() {
        List<MenuItems> items = new ArrayList<>();
        items.add(addProductMenuItem);
        items.add(findProductByIdMenuItem);
        items.add(exitMenuItem);
        return new ConsoleUI(items);
    }

}

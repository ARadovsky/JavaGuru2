package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.Menu.MenuItems;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<MenuItems> items;

    @Autowired
    public ConsoleUI(List<MenuItems> items) {
        this.items = items;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int userResponse = 0;

        while (userResponse >= 0) {
            printMenu();
            try {
                userResponse = Integer.parseInt(scanner.nextLine());
                items.get(userResponse).execute();
            } catch (ProductValidationException e) {
                System.out.println("Error! " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i));
        }
    }

}
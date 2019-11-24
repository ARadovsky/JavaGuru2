package com.javaguru.shoppinglist.console.Menu;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindProductByIdMenuItem implements  MenuItems{

    private static final String MENUITEM_NAME = "Find product by id";

    private final ProductService productService;

    public FindProductByIdMenuItem(ProductService productService){
        this.productService=productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        Product result = productService.findProductById(id);
        System.out.println("Result: " + result);
    }

    @Override
    public String toString() {

        return MENUITEM_NAME;
    }

}

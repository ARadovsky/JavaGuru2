package com.javaguru.shoppinglist.console.Menu;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationException;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class AddProductMenuItem implements MenuItems {

    private static final String MENUITEM_NAME = "Create product";

    private final ProductService productService;

    public AddProductMenuItem(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setDescription(description);
        try {
            Long result = productService.addProduct(product);
            System.out.println("Result: " + result);
        } catch (ProductValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {

        return MENUITEM_NAME;
    }

}

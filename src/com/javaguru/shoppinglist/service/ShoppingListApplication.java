package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductDiscountMaxValueValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductNameMaxLengthValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductNameMinLengthValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductNameNotNullValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductNameUniqueValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductPriceMinValueValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductValidationRule;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductValidationService;

import java.util.HashSet;
import java.util.Set;

public class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();

        ProductValidationRule productNameNotNullValidationRule = new ProductNameNotNullValidationRule();
        ProductValidationRule productNameMinLengthValidationRule = new ProductNameMinLengthValidationRule();
        ProductValidationRule productNameMaxLengthValidationRule = new ProductNameMaxLengthValidationRule();
        ProductValidationRule productNameUniqueValidationRule = new ProductNameUniqueValidationRule(repository);
        ProductValidationRule productPriceMinValueValidationRule = new ProductPriceMinValueValidationRule();
        ProductValidationRule productDiscountMaxValueValidationRule = new ProductDiscountMaxValueValidationRule();
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(productNameNotNullValidationRule);
        rules.add(productNameMinLengthValidationRule);
        rules.add(productNameMaxLengthValidationRule);
        rules.add(productNameUniqueValidationRule);
        rules.add(productPriceMinValueValidationRule);
        rules.add(productDiscountMaxValueValidationRule);

        ProductValidationService validationService = new ProductValidationService(rules);

        ProductService productService = new ProductService(repository, validationService);

        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }

}

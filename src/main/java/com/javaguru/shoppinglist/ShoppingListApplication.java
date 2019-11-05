package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.config.AppConfig;
import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.productValidationService.ProductDiscountMaxValueValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductDiscountMinValueValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductDiscountValueFromPriceValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductNameMaxLengthValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductNameMinLengthValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductNameNotNullValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductNameUniqueValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductPriceMinValueValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationRule;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI console = context.getBean(ConsoleUI.class);
        console.execute();
    }

}

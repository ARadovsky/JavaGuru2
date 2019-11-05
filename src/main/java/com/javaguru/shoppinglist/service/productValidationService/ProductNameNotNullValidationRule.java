package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductNameNotNullValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        }
    }
}

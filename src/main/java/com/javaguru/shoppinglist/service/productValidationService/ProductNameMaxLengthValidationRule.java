package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductNameMaxLengthValidationRule implements ProductValidationRule {

    private static final int NAME_LENGTH_MAX_VALUE = 32;

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getName().length() > NAME_LENGTH_MAX_VALUE) {
            throw new ProductValidationException("Product name must be less or equal " + NAME_LENGTH_MAX_VALUE);
        }
    }
}

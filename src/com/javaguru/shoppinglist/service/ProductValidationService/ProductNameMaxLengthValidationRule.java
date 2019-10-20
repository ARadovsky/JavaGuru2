package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameMaxLengthValidationRule implements ProductValidationRule {

    private final int NAME_LENGTH_MAX_VALUE = 32;

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getName().length() > NAME_LENGTH_MAX_VALUE) {
            throw new ProductValidationException("Product name must be less or equal " + NAME_LENGTH_MAX_VALUE);
        }
    }
}

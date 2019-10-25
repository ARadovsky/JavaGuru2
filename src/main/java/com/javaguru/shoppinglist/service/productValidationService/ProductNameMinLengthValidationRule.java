package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameMinLengthValidationRule implements ProductValidationRule {

    private static final int NAME_LENGTH_MIN_VALUE = 3;

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < NAME_LENGTH_MIN_VALUE) {
            throw new ProductValidationException("Product name must be greater or equal " + NAME_LENGTH_MIN_VALUE);
        }
    }
}

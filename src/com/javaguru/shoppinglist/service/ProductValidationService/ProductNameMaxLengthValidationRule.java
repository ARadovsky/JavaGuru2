package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameMaxLengthValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        int maxNameLength = 32;
        if (product.getName().length() > maxNameLength) {
            throw new ProductValidationException("Product name must be less or equal " + maxNameLength);
        }
    }
}

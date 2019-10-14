package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameMinLengthValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < 3) {
            throw new ProductValidationException("Product name must be greater or equal 3.");
        }
    }
}

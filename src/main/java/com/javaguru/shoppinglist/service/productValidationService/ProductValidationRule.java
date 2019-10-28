package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

    default void checkNotNull(Product task) {
        if (task == null) {
            throw new ProductValidationException("Product must be not null");
        }
    }
}

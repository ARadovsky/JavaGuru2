package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountMaxValueValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new ProductValidationException("Product discount must be be less than 100.");
        }
    }
}

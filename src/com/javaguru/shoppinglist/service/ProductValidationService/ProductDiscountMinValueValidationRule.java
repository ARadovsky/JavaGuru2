package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountMinValueValidationRule implements ProductValidationRule {

    private final BigDecimal DISCOUNT_MIN_VALUE = new BigDecimal(0);

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getDiscount().compareTo(DISCOUNT_MIN_VALUE) <= 0) {
            throw new ProductValidationException("Product discount must be be great than " + DISCOUNT_MIN_VALUE);
        }
    }

}

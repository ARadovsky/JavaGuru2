package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValueFromPriceValidationRule implements ProductValidationRule {

    private static final BigDecimal PRICE_MIN_VALUE = new BigDecimal(20);

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getPrice().compareTo(PRICE_MIN_VALUE) <= 0) {
            throw new ProductValidationException("Product price must be be greater than " + PRICE_MIN_VALUE);
        }
    }

}
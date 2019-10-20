package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceMinValueValidationRule implements ProductValidationRule {

    private final BigDecimal PRICE_MIN_VALUE = new BigDecimal(0);

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(PRICE_MIN_VALUE) <= 0) {
            throw new ProductValidationException("Product price must be greater than " + PRICE_MIN_VALUE);
        }
    }
}

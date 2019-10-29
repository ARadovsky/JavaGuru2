package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountMaxValueValidationRule implements ProductValidationRule {

    private static final BigDecimal DISCOUNT_MAX_VALUE = new BigDecimal(100);

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getDiscount().compareTo(DISCOUNT_MAX_VALUE) > 0) {
            throw new ProductValidationException("Product discount must be be less than " + DISCOUNT_MAX_VALUE);
        }
    }
}

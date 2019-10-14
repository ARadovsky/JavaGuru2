package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceMinValueValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new ProductValidationException("Product price must be greater than 0.");
        }
    }
}

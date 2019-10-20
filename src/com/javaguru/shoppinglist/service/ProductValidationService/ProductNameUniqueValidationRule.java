package com.javaguru.shoppinglist.service.ProductValidationService;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

public class ProductNameUniqueValidationRule implements ProductValidationRule {

    private final ProductRepository repository;

    public ProductNameUniqueValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (repository.isProductNameUnique(product.getName())) {
            throw new ProductValidationException("Product name must be unique.");
        }
    }
}

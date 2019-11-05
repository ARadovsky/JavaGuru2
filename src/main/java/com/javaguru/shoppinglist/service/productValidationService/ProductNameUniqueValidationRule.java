package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductNameUniqueValidationRule implements ProductValidationRule {

    private final ProductRepository repository;

    @Autowired
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

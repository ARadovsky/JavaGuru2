package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductValidationService.ProductValidationService;

import java.util.Map;
import java.util.NoSuchElementException;

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;

    public ProductService(ProductRepository productRepository, ProductValidationService validationService) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    public Long addProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = productRepository.save(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {

        return productRepository.findProductById(id).orElseThrow(() -> new NoSuchElementException("Product not found, id: " + id));
    }

}

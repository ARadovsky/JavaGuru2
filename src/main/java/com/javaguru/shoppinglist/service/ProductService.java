package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Component
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductValidationService validationService) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    @Transactional
    public Long addProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = productRepository.save(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(() -> new NoSuchElementException("Product not found, id: " + id));
    }

}
package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.map.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Component
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;
    private final ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductValidationService validationService, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.validationService = validationService;
        this.productConverter = productConverter;
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

    public List<ProductDTO> showAllProducts() {
        return productRepository.showAllProducts().stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.findProductById(id)
                .ifPresent(productRepository::delete);
    }
}
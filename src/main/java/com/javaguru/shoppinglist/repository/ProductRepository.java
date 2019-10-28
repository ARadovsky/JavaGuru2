package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductRepository {

    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product save(Product product) {
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public boolean isProductNameUnique(String name) {
        return products.values().stream().anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }
}

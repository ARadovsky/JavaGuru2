package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inMemory")
public class ProductRepositoryInMemory implements ProductRepository {

    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    @Override
    public Product save(Product product) {
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public boolean isProductNameUnique(String name) {
        return products.values().stream().anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }
}

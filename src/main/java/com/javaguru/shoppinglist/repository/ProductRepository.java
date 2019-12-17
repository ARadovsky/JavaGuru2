package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findProductById(Long id);

    List<Product> showAllProducts();

    boolean isProductNameUnique(String name);

    void delete(Product product);

}

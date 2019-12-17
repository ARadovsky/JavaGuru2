package com.javaguru.shoppinglist.map;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDiscount(productDTO.getDiscount());
        product.setDescription(productDTO.getDescription());
        product.setId(productDTO.getId());
        return product;
    }

    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setDescription(product.getDescription());
        productDTO.setId(product.getId());
        return productDTO;
    }
}

package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepositoryTest {

    private static final Long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "Bananas";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(5);
    private static final String PRODUCT_CATEGORY = "Food";
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Ecuador fruits";

    private ProductRepository victim = new ProductRepository();

    private Product product = product();

    @Test
    public void shouldSave() {
        Product result = victim.save(product);

        assertThat(result).isEqualTo(expectedProduct());
    }

    @Test
    public void shouldFindByID() {
        victim.save(product);

        Optional<Product> result = victim.findProductById(PRODUCT_ID);
        assertThat(result).isNotEmpty();
        assertThat(result).hasValue(expectedProduct());
    }

    @Test
    public void shouldIsProductNameUnique() {
        victim.save(product);

        boolean result = victim.isProductNameUnique(PRODUCT_NAME);
        assertThat(result).isTrue();
    }

    private Product expectedProduct() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName(PRODUCT_NAME);
        product.setPrice(PRODUCT_PRICE);
        product.setCategory(PRODUCT_CATEGORY);
        product.setDiscount(PRODUCT_DISCOUNT);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
    }

    private Product product() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName(PRODUCT_NAME);
        product.setPrice(PRODUCT_PRICE);
        product.setCategory(PRODUCT_CATEGORY);
        product.setDiscount(PRODUCT_DISCOUNT);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
    }
}
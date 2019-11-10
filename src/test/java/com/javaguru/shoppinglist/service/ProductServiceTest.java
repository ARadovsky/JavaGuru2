package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepositoryInMemory;
import com.javaguru.shoppinglist.service.productValidationService.ProductValidationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private static final Long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "Bananas";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(5);
    private static final String PRODUCT_CATEGORY = "Food";
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Ecuador fruits";

    @Mock
    private ProductRepositoryInMemory repository;

    @Mock
    private ProductValidationService validationService;

    @InjectMocks
    private ProductService victim;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    public void shouldAddProduct() {

        Product product = product();
        when(repository.save(product)).thenReturn(product);

        Long result = victim.addProduct(product);

        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();

        assertThat(captorResult).isEqualTo(product);
        assertThat(product.getId()).isEqualTo(result);

    }

    @Test
    public void shouldFindProductById() {
        when(repository.findProductById(PRODUCT_ID)).thenReturn(Optional.ofNullable(product()));

        Product result = victim.findProductById(PRODUCT_ID);

        assertThat(result).isEqualTo(product());
    }

    @Test
    public void shouldThrowExceptionTaskNotFound() {
        when(repository.findProductById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> victim.findProductById(0L))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Product not found, id: " + 0L);
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

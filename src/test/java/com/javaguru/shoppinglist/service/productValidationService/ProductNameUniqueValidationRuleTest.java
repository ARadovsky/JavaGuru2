package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepositoryHibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameUniqueValidationRuleTest {

    private static final Long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "Bananas";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(5);
    private static final String PRODUCT_CATEGORY = "Food";
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Ecuador fruits";

    @Mock
    private ProductRepositoryHibernate productRepository;

    @Spy
    @InjectMocks
    ProductNameUniqueValidationRule victim;

    private Product product = product();

    @Test
    public void shouldTrowException() {
        when(productRepository.isProductNameUnique(product.getName()))
                .thenReturn(true);
        assertThatThrownBy(() -> victim.validate(product))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be unique.");
        verify(victim).checkNotNull(product);
    }

    @Test
    public void shouldValidateSuccess() {
        when(productRepository.isProductNameUnique(product.getName()))
                .thenReturn(false);

        victim.validate(product);

        verify(victim).checkNotNull(product);
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

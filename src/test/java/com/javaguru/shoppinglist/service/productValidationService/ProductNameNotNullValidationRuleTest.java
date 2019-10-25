package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameNotNullValidationRuleTest {

    private static final Long PRODUCT_ID = 0L;
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(5);
    private static final String PRODUCT_CATEGORY = "Food";
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Ecuador fruits";

    @Spy
    private ProductNameNotNullValidationRule victim;

    private Product input;

    @Test
    public void shouldTrowProductValidationException() {
        input = product(null);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be not null.");
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product("Bananas");

        victim.validate(input);

        verify(victim).checkNotNull(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName(name);
        product.setPrice(PRODUCT_PRICE);
        product.setCategory(PRODUCT_CATEGORY);
        product.setDiscount(PRODUCT_DISCOUNT);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
    }
}

package com.javaguru.shoppinglist.service.productValidationService;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    private static final Long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "Bananas";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(5);
    private static final String PRODUCT_CATEGORY = "Food";
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Ecuador fruits";

    @Mock
    private ProductNameUniqueValidationRule nameUniqueValidationRule;

    @Mock
    private ProductNameNotNullValidationRule nameNotNullValidationRule;

    @Mock
    private ProductNameMaxLengthValidationRule nameMaxLengthValidationRule;

    @Mock
    private ProductNameMinLengthValidationRule nameMinLengthValidationRule;

    @Captor
    private ArgumentCaptor<Product> captor;

    private ProductValidationService victim;

    private Product product = product();

    @Before
    public void setUp() {
        Set<ProductValidationRule> validationRules = new HashSet<>();
        validationRules.add(nameUniqueValidationRule);
        validationRules.add(nameNotNullValidationRule);
        validationRules.add(nameMaxLengthValidationRule);
        validationRules.add(nameMinLengthValidationRule);

        victim = new ProductValidationService(validationRules);
    }

    @Test
    public void shouldValidate() {
        victim.validate(product);

        verify(nameUniqueValidationRule).validate(captor.capture());
        verify(nameNotNullValidationRule).validate(captor.capture());
        verify(nameMaxLengthValidationRule).validate(captor.capture());
        verify(nameMinLengthValidationRule).validate(captor.capture());

        List<Product> resultList = captor.getAllValues();
        assertThat(resultList).containsOnly(product);
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

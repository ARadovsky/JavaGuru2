package com.javaguru.shoppinglist.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal discount;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, BigDecimal price, String category, BigDecimal discount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductDTO productDTO = (ProductDTO) obj;
        return Objects.equals(id, productDTO.id) &&
                Objects.equals(name, productDTO.name) &&
                Objects.equals(description, productDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id + ", " +
                "name='" + name + '\'' + ", " +
                "price=" + price + "\', " +
                "category='" + category + '\'' +
                "discount=" + discount + "\', " +
                "description='" + description + '\'' +
                '}';
    }

}

package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
@Profile("db_dev")
public class ProductRepositoryDB implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    ProductRepositoryDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product save(Product product) {
        String sql = "insert into products (name, description, category, price, discount) values (" +
                "?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice().doubleValue());
            ps.setDouble(5, product.getDiscount().doubleValue());
            return ps;
        }, keyHolder);

        product.setId(keyHolder.getKey().longValue());
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        String sql = "select * from products where id=?";
        List<Product> products = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Product.class), id);
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();
    }

    @Override
    public boolean isProductNameUnique(String name) {
        String sql = "SELECT CASE WHEN count(*) > 0 " +
                "THEN true ELSE false END " +
                "FROM products p where p.name=?";
        return jdbcTemplate.queryForObject(sql, Boolean.class, name);
    }

}

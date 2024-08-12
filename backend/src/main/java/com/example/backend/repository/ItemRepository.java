package com.example.backend.repository;

import com.example.backend.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Item> itemRowMapper = (r, i) -> {
        Item item = new Item();
        item.setCategoryId(r.getInt("category_id"));
        item.setSizeId(r.getInt("size_id"));
        item.setBrandId(r.getInt("bran_id"));
        item.setSellerId(r.getInt("seller_id"));
        item.setName(r.getString("name"));
        item.setDescription(r.getString("description"));
        item.setPrice(r.getBigDecimal("price"));
        item.setUserId(r.getInt("user_id"));

        return item;
    };

    public void storeItem(Item item) {
        // item or Item
        String sql = "INSERT INTO item values(?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                item.getCategoryId(),
                item.getSizeId(),
                item.getBrandId(),
                item.getSellerId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getUserId());
    }
    // id long or int
    public List<Item> getItemsByCategoryId(int categoryID) {
        String sql = "SELECT * FROM item WHERE category_id = ?";
        return jdbcTemplate.query(sql, itemRowMapper, categoryID);
    }


}

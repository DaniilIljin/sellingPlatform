package com.example.backend.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.backend.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    List<Item> findAllByCategoryId(Long categoryId);

    List<Item> findAllBySizeId(Long sizeId);

    List<Item> findAllByBrandId(Long brandId);

    List<Item> findAllBySellerId(Long sellerId);

    List<Item> findAllByNameContains(String name);

    Optional<Item> findAllByNameEquals(String name);

    List<Item> findAllByStatus(Integer status);

    List<Item> findAllByDescriptionContains(String description);

    List<Item> findAllByPriceIsGreaterThan(BigDecimal price);

    List<Item> findAllByPriceIsLessThan(BigDecimal price);

    List<Item> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Item> findAllByUserId(Long userId);

    //@EntityGraph(attributePaths = "category")
    Optional<Item> findById(Long id);

    //@EntityGraph(attributePaths = "category")
    List<Item> findAll();
}

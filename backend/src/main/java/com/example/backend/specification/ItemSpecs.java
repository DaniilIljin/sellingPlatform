package com.example.backend.specification;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.example.backend.model.Item;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Component
public class ItemSpecs {

    //мб ненужная хуйня но пусть пока будет

    public static Specification<Item> buildSpecification(Long categoryId, Long sizeId,
                                                         Long brandId, Long sellerId, String name,
                                                         Integer status, String description,
                                                         BigDecimal minPrice, BigDecimal maxPrice,
                                                         Long userId) {

        return Specification.where(byCategoryId(categoryId))
                .and(bySizeId(sizeId))
                .and(byBrandId(brandId))
                .and(bySellerId(sellerId))
                .and(byContainsName(name))
                .and(byStatus(status))
                .and(byContainsDescription(description))
                .and(byPriceBetween(minPrice, maxPrice))
                .and(byUserId(userId));
    }

    public static Specification<Item> byCategoryId(Long categoryId) {
        return (Root<Item> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (categoryId == null) return null;
            return builder.equal(root.get("categoryId").get("id"), categoryId);
        };
    }

    public static Specification<Item> bySizeId(Long sizeId) {
        return (root, query, criteriaBuilder) -> {
            if (sizeId == null) return null;
            return criteriaBuilder.equal(root.get("size").get("id"), sizeId);
        };
    }

    public static Specification<Item> byBrandId(Long brandId) {
        return (root, query, criteriaBuilder) -> {
            if (brandId == null) return null;
            return criteriaBuilder.equal(root.get("brand").get("id"), brandId);
        };
    }

    public static Specification<Item> bySellerId(Long sellerId) {
        return (root, query, criteriaBuilder) -> {
            if (sellerId == null) return null;
            return criteriaBuilder.equal(root.get("seller").get("id"), sellerId);
        };
    }

    public static Specification<Item> byContainsName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            String pattern = "%" + name + "%";
            return criteriaBuilder.like(root.get("name"), pattern);
        };
    }

    public static Specification<Item> byStatus(Integer status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) return null;
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<Item> byContainsDescription(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null || description.isEmpty()) return null;
            String pattern = "%" + description + "%";
            return criteriaBuilder.like(root.get("description"), pattern);
        };
    }

    public static Specification<Item> byPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) return null;
            if (minPrice == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            if (maxPrice == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
            return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
        };
    }

    public static Specification<Item> byUserId(Long userId) {
        return (root, query, criteriaBuilder) -> {
            if (userId == null) return null;
            return criteriaBuilder.equal(root.get("user").get("id"), userId);
        };
    }
}


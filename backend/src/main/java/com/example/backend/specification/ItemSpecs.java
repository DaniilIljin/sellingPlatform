package com.example.backend.specification;

import com.example.backend.model.Category;
import com.example.backend.model.Item;
import com.example.backend.model.Size;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ItemSpecs {

    public static Specification<Item> hasCategoryId(Long categoryId) {
        return (Root<Item> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (categoryId == null) return null;
            Join<Item, Category> categoryJoin = root.join("category", JoinType.INNER);
            return builder.equal(categoryJoin.get("category_id"), categoryId);
        };
    }

    public static Specification<Item> hasSize(Long size) {
        return (root, query, criteriaBuilder) -> {
            if (size == null) return null;
            return criteriaBuilder.equal(root.get("size"), size);
        };
    }

    public static Specification<Item> hasBrandId(Long brandId) {
        return (root, query, criteriaBuilder) -> {
            if (brandId == null) return null;
            return criteriaBuilder.equal(root.get("brandId"), brandId);
        };
    }

    public static Specification<Item> hasSellerId(Long sellerId) {
        return (root, query, criteriaBuilder) -> {
            if (sellerId == null) return null;
            return criteriaBuilder.equal(root.get("sellerId"), sellerId);
        };
    }

    public static Specification<Item> containsName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            String pattern = "%" + name + "%";
            return criteriaBuilder.like(root.get("name"), pattern);
        };
    }

    public static Specification<Item> hasStatus(Integer status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) return null;
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<Item> containsDescription(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null || description.isEmpty()) return null;
            String pattern = "%" + description + "%";
            return criteriaBuilder.like(root.get("description"), pattern);
        };
    }

    public static Specification<Item> hasPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
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

    public static Specification<Item> hasUserId(Long userId) {
        return (root, query, criteriaBuilder) -> {
            if (userId == null) return null;
            return criteriaBuilder.equal(root.get("userId"), userId);
        };
    }
}


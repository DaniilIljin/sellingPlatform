package com.example.backend.service;

import com.example.backend.model.Item;
import com.example.backend.specification.ItemSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final RepositoryManager repositoryManager;

    public List<Item> getItemsByParams(Long categoryId, Long sizeId, Long brandId,
                               Long sellerId, String name, int status,
                               String description, BigDecimal minPrice,
                                       BigDecimal maxPrice, Long userId)  {

        return repositoryManager.getItemRepository().findAll(ItemSpecs.buildSpecification(
                categoryId, sizeId, brandId, sellerId,
                name, status, description, minPrice, maxPrice, userId
        ));
    };

    public List<Item> getAllItems() {
        return repositoryManager.getItemRepository().findAll();
    }

    public Item getItemById(Long id) {
        return repositoryManager.getItemRepository().findById(id).get();
    }

}

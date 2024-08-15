package com.example.backend.service;

import com.example.backend.model.Item;
import com.example.backend.specification.ItemSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final RepositoryManager repositoryManager;

    public List<Item> getItems(Long categoryId, Long sizeId, Long brandId,
                               Long sellerId, String name, int status,
                               String description, BigDecimal price, Long userId)  {

        Specification<Item> spec = Specification.where(ItemSpecs.hasBrandId(brandId))
                .and(ItemSpecs.hasCategoryId(categoryId))
                        .and(ItemSpecs.hasStatus(status));
        return repositoryManager.getItemRepository().findAll(spec);
    };
}

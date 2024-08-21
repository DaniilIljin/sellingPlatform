package com.example.backend.service;

import com.example.backend.dto.ItemDTO;
import com.example.backend.exception.ItemNotFoundException;
import com.example.backend.mapper.ItemMapper;
import com.example.backend.model.Item;
import com.example.backend.specification.ItemSpecs;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final RepositoryManager repositoryManager;

    private final ItemMapper mapper;

    public List<Item> getItemsByParams(Long categoryId, Long sizeId, Long brandId,
                               Long sellerId, String name, int status,
                               String description, BigDecimal minPrice,
                                       BigDecimal maxPrice, Long userId)  {

        return repositoryManager.getItemRepository().findAll(ItemSpecs.buildSpecification(
                categoryId, sizeId, brandId, sellerId,
                name, status, description, minPrice, maxPrice, userId
        ));
    };

    public List<ItemDTO> getAllItems() {
        return repositoryManager.
                getItemRepository().
                findAll().
                stream().
                map(mapper::convertItemToItemDTO).
                toList();
    }


    public ItemDTO getItemById(Long id) {
        return repositoryManager.
                getItemRepository().
                findById(id).
                map(mapper::convertItemToItemDTO).
                orElseThrow(() -> new ItemNotFoundException("Could not find item with id=" + id, id, null));
    }

}

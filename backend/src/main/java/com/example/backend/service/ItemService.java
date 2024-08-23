package com.example.backend.service;

import com.example.backend.dto.ItemCreateDTO;
import com.example.backend.dto.ItemDTO;
import com.example.backend.mapper.ItemMapper;
import com.example.backend.model.Brand;
import com.example.backend.model.Category;
import com.example.backend.model.Item;
import com.example.backend.model.Size;
import com.example.backend.security.User;
import com.example.backend.specification.ItemSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final RepositoryManager repositoryManager;

    private final ItemMapper mapper;

    private final EntityManager entityManager;

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
        return repositoryManager
                .getItemRepository()
                .findAll()
                .stream()
                .map(mapper::convertItemToItemDTO)
                .toList();
    }


    public ItemDTO getItemById(Long id) {
        return repositoryManager
                .getItemRepository()
                .findById(id)
                .map(mapper::convertItemToItemDTO)
                .orElseThrow(() -> new EntityNotFoundException("Item wasn't found"));
    }

    public List<ItemDTO> getItemsByCategoryId(Long categoryId) {
        return repositoryManager
                .getItemRepository()
                .findAllByCategoryId(categoryId)
                .stream()
                .map(mapper::convertItemToItemDTO)
                .toList();
    }

    public Item saveItem(ItemCreateDTO itemCreateDTO) {

        Category category = entityManager.getReference(Category.class, itemCreateDTO.getCategoryId());
        Size size = entityManager.getReference(Size.class, itemCreateDTO.getSizeId());
        Brand brand = entityManager.getReference(Brand.class, itemCreateDTO.getBrandId());
        User seller = entityManager.getReference(User.class, itemCreateDTO.getSellerId());
        String name = itemCreateDTO.getName();
        String description = itemCreateDTO.getDescription();
        BigDecimal price = itemCreateDTO.getPrice();

        Item item = new Item();

        item.setCategory(category);
        item.setSize(size);
        item.setBrand(brand);
        item.setSeller(seller);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setStatus(0);

        return repositoryManager.getItemRepository().save(item);

    }

}

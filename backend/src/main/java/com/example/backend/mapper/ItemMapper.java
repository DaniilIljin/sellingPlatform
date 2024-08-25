package com.example.backend.mapper;

import com.example.backend.dto.ItemFullDTO;
import com.example.backend.model.Brand;
import com.example.backend.model.Category;
import com.example.backend.model.Size;
import com.example.backend.security.User;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.backend.dto.ItemDTO;
import com.example.backend.model.Item;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ItemMapper {

    private final ModelMapper mapper;

    private final EntityManager entityManager;

    public ItemDTO convertItemToItemDTO(Item object){
        return mapper.map(object, ItemDTO.class);
    }
    public Item convertItemDTOToItem(ItemDTO object){
        return mapper.map(object, Item.class);
    }

    public Item convertItemFullDTOtoItem(ItemFullDTO itemFullDTO) {

        Category category = entityManager
                .getReference(Category.class, itemFullDTO.getCategoryId());

        Size size = entityManager
                .getReference(Size.class, itemFullDTO.getSizeId());

        Brand brand = entityManager
                .getReference(Brand.class, itemFullDTO.getBrandId());

        User seller = entityManager
                .getReference(User.class, itemFullDTO.getSellerId());

        User user = null;

        if (itemFullDTO.getUserId() != null) user = entityManager
                .getReference(User.class, itemFullDTO.getUserId());

        int status;

        if (itemFullDTO.getStatus() == null)  status = 0;
        else status = itemFullDTO.getStatus();

        String name = itemFullDTO.getName();
        String description = itemFullDTO.getDescription();
        BigDecimal price = itemFullDTO.getPrice();

        Item item = new Item();

        item.setCategory(category);
        item.setSize(size);
        item.setBrand(brand);
        item.setSeller(seller);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setStatus(status);
        item.setUser(user);

        return item;
    }
}

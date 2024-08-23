package com.example.backend.mapper;

import com.example.backend.dto.ItemCreateDTO;
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

    public Item convertItemCreateDTOtoItem(ItemCreateDTO itemCreateDTO) {

        Category category = entityManager
                .getReference(Category.class, itemCreateDTO.getCategoryId());

        Size size = entityManager
                .getReference(Size.class, itemCreateDTO.getSizeId());

        Brand brand = entityManager
                .getReference(Brand.class, itemCreateDTO.getBrandId());

        User seller = entityManager
                .getReference(User.class, itemCreateDTO.getSellerId());

        User user = null;

        if (itemCreateDTO.getUserId() != null) user = entityManager
                .getReference(User.class, itemCreateDTO.getUserId());

        int status;

        if (itemCreateDTO.getStatus() == null)  status = 0;
        else status = itemCreateDTO.getStatus();

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
        item.setStatus(status);
        item.setUser(user);

        return item;
    }
}

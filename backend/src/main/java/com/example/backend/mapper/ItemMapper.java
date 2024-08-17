package com.example.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.backend.dto.ItemDTO;
import com.example.backend.model.Item;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemMapper {
    private final ModelMapper mapper;

    public ItemDTO convertLocationToLocationDTO(Item object){
        return mapper.map(object, ItemDTO.class);
    }
    public Item convertLocationDTOToLocation(ItemDTO object){
        return mapper.map(object, Item.class);
    }
}

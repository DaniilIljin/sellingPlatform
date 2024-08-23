package com.example.backend;

import java.math.BigDecimal;
import java.util.List;

import com.example.backend.dto.ItemCreateDTO;
import com.example.backend.dto.ItemDTO;
import com.example.backend.mapper.CategoryMapper;
import com.example.backend.mapper.ItemMapper;
import com.example.backend.model.Category;
import com.example.backend.service.ItemService;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import com.example.backend.model.Item;
import com.example.backend.repository.BrandRepository;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ItemRepository;
import com.example.backend.repository.SizeRepository;
import com.example.backend.specification.ItemSpecs;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//	@Bean
//	CommandLineRunner commandLineRunner(BrandRepository brandRepository, CategoryRepository categoryRepository,
//										ItemRepository itemRepository, SizeRepository sizeRepository,
//										ItemService itemService, CategoryMapper categoryMapper,
//										ItemMapper itemMapper) {
//		return args -> {
//
//			ItemCreateDTO itemCreateDTO = new ItemCreateDTO();
//			itemCreateDTO.setName("asd");
//			itemCreateDTO.setPrice(new BigDecimal(123));
//			itemCreateDTO.setDescription("sad");
//			itemCreateDTO.setStatus(0);
//			itemCreateDTO.setBrandId(1L);
//			itemCreateDTO.setCategoryId(2L);
//			itemCreateDTO.setSizeId(1L);
//			itemCreateDTO.setSellerId(1L);
//			itemCreateDTO.setUserId(2L);
//
////			Item item = itemMapper.convertItemCreateDTOtoItem(itemCreateDTO);
//
//
//			itemService.updateItem(4L, itemCreateDTO);
//		};
//	};
}

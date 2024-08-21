package com.example.backend;

import java.util.List;

import com.example.backend.dto.ItemDTO;
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
//										ItemService itemService, ModelMapper modelMapper) {
//		return args -> {
//
//			//ItemDTO itemDTO = itemService.getItemById(1L);
//			//ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
//			//Item item = itemRepository.findById(1L).get();
//
////			Item item = itemRepository.findById(1L).get();
////			System.out.println(item.getCategory().getName());
//
//		};
//	};
}

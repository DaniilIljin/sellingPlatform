package com.example.backend;

import com.example.backend.model.Category;
import com.example.backend.model.Item;
import com.example.backend.model.Size;
import com.example.backend.repository.BrandRepository;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ItemRepository;
import com.example.backend.repository.SizeRepository;
import com.example.backend.specification.ItemSpecs;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BrandRepository brandRepository, CategoryRepository categoryRepository,
										ItemRepository itemRepository, SizeRepository sizeRepository) {
		return args -> {

			Specification<Item> specification = Specification.where(ItemSpecs.hasSize(2L));
			List<Item> items = itemRepository.findAll(specification);
			items.forEach(o -> System.out.println(o.getName()));
		};
	};
}

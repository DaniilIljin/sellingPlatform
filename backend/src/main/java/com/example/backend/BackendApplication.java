package com.example.backend;

import java.util.List;

import com.example.backend.dto.ItemDTO;
import com.example.backend.mapper.CategoryMapper;
import com.example.backend.model.Category;
import com.example.backend.model.RefreshToken;
import com.example.backend.repository.*;
import com.example.backend.service.ItemService;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import com.example.backend.model.Item;
import com.example.backend.specification.ItemSpecs;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

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
//										PasswordEncoder passwordEncoder, RefreshTokenRepository refreshTokenRepository) {
//		return args -> {
//			//asffasfaf.asdasd.123asffa
//			System.out.println(passwordEncoder.encode("asffasfaf.asdasd.123asffa"));
//			System.out.println(passwordEncoder.encode("asffasfaf.asdasd.123asffa"));
//			System.out.println(passwordEncoder.encode("asffasfaf.asdasd.123asffa"));
//
//			RefreshToken refreshToken = refreshTokenRepository.findByToken("$2a$10$P2s/bU8pqdcW0UzgIomcZ.XKNr5C.ABsJLRfHTm8ZW/UmpJyH28v6").orElseThrow();
//			System.out.println(refreshToken.getToken());
//		};
//
//		//$2a$10$XI4SCI8fuGcMC0sA9ZbwKuSvcubJ/iBYDzpZCxNhUYt6720yjcqcu
//		//
//	};
}

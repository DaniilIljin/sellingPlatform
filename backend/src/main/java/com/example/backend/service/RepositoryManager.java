package com.example.backend.service;

import org.springframework.stereotype.Component;

import com.example.backend.repository.BrandRepository;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ItemRepository;
import com.example.backend.repository.PictureRepository;
import com.example.backend.repository.SizeRepository;
import com.example.backend.repository.UserRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Data
public class RepositoryManager {

    private final BrandRepository brandRepository;

    private final CategoryRepository categoryRepository;

    private final ItemRepository itemRepository;

    private final PictureRepository pictureRepository;

    private final SizeRepository sizeRepository;

    private final UserRepository userRepository;
}

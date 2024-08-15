package com.example.backend.service;


import com.example.backend.repository.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RepositoryManager {

    private final BrandRepository brandRepository;

    private final CategoryRepository categoryRepository;

    private final ItemRepository itemRepository;

    private final PictureRepository pictureRepository;

    private final SizeRepository sizeRepository;

    private final UserRepository userRepository;
}

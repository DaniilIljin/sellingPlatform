package com.example.backend.service;

import com.example.backend.repository.*;
import org.springframework.stereotype.Component;

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

    private final RefreshTokenRepository refreshTokenRepository;
}

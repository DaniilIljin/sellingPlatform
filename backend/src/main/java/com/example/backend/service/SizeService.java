package com.example.backend.service;

import com.example.backend.dto.SizeDTO;
import com.example.backend.mapper.SizeMapper;
import com.example.backend.model.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeService {

    private final RepositoryManager repositoryManager;

    private final SizeMapper mapper;

    public SizeDTO getSizeById(Long id) {
        return mapper.
                convertSizeToSizeDTO(repositoryManager.
                        getSizeRepository().
                        findById(id).
                        get());
    }


    public List<SizeDTO> getAllSizes() {
        return repositoryManager.
                getSizeRepository().
                findAll().
                stream().
                map(mapper::convertSizeToSizeDTO).
                toList();
    }
}

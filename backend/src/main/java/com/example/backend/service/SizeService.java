package com.example.backend.service;

import com.example.backend.dto.SizeDTO;
import com.example.backend.mapper.SizeMapper;
import com.example.backend.model.Size;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeService {

    private final RepositoryManager repositoryManager;

    private final SizeMapper mapper;

    public SizeDTO getSizeById(Long id) {
        return repositoryManager
                .getSizeRepository()
                .findById(id)
                .map(mapper::convertSizeToSizeDTO)
                .orElseThrow(() -> new EntityNotFoundException("Size wasn't found"));
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

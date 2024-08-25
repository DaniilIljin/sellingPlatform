package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Size;
import org.springframework.stereotype.Service;

import com.example.backend.dto.SizeDTO;
import com.example.backend.mapper.SizeMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

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

    public Size saveSize(SizeDTO sizeDTO) {
        Size size = mapper.convertSizeDTOToSize(sizeDTO);
        return repositoryManager
                .getSizeRepository()
                .save(size);
    }
}

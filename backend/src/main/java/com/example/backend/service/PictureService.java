package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.dto.PictureDTO;
import com.example.backend.mapper.PictureMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final RepositoryManager repositoryManager;

    private final PictureMapper mapper;

    public List<PictureDTO> getAllPictures() {
        return repositoryManager
                .getPictureRepository()
                .findAll()
                .stream()
                .map(mapper::convertPictureToPictureDTO)
                .toList();
    }

    public PictureDTO getPictureById(Long id) {
        return repositoryManager
                .getPictureRepository()
                .findById(id)
                .map(mapper::convertPictureToPictureDTO)
                .orElseThrow(() -> new EntityNotFoundException("Picture wasn't found"));
    }

    public List<PictureDTO> getPicturesByItemId(Long id) {
        return repositoryManager
                .getPictureRepository()
                .findAllByItemId(id)
                .stream()
                .map(mapper::convertPictureToPictureDTO)
                .toList();
    }
}

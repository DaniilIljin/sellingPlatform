package com.example.backend.service;

import com.example.backend.model.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeService {

    private final RepositoryManager repositoryManager;

    public Size getSizeById(Long id) {
        return repositoryManager.getSizeRepository().findById(id).get();
    }


    public List<Size> getAllSizes() {
        return repositoryManager.getSizeRepository().findAll();
    }
}

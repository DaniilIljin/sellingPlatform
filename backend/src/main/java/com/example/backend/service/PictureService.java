package com.example.backend.service;

import com.example.backend.model.Picture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final RepositoryManager repositoryManager;

    public List<Picture> getAllPictures() {
        return repositoryManager.getPictureRepository().findAll();
    }

    public Picture getPictureById(Long id) {
        return repositoryManager.getPictureRepository().findById(id).get();
    }

    public List<Picture> getPicturesByItemId(Long id) {
        return repositoryManager.getPictureRepository().findAllByItemId(id);
    }
}

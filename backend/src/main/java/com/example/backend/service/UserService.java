package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RepositoryManager repositoryManager;

    private final UserMapper mapper;

    public UserDTO getUserById(Long id) {
        return repositoryManager
                .getUserRepository()
                .findById(id)
                .map(mapper::convertUserToUserDTO)
                .orElseThrow(() -> new EntityNotFoundException("User wasn't found"));
    }

    public List<UserDTO> getAllUsers() {
        return repositoryManager
                .getUserRepository()
                .findAll()
                .stream()
                .map(mapper::convertUserToUserDTO)
                .toList();
    }


}

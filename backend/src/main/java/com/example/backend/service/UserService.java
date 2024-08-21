package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.mapper.UserMapper;
import com.example.backend.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RepositoryManager repositoryManager;

    private final UserMapper mapper;

    public UserDTO getUserById(Long id) {
        return mapper.
                convertUserToUserDRO(repositoryManager.
                        getUserRepository().
                        findById(id).
                        get());
    }

    public List<UserDTO> getAllUsers() {
        return repositoryManager.
                getUserRepository().
                findAll().
                stream().
                map(mapper::convertUserToUserDRO).
                toList();
    }


}

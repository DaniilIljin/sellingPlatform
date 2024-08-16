package com.example.backend.service;

import com.example.backend.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RepositoryManager repositoryManager;

    public User getUserById(Long id) {
        return repositoryManager.getUserRepository().findById(id).get();
    }

    public List<User> getAllUsers() {
        return repositoryManager.getUserRepository().findAll();
    }

}

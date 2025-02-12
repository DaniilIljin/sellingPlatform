package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.dto.UserRegisterDTO;
import com.example.backend.exception.UsernameAlreadyExistsException;
import com.example.backend.mapper.UserMapper;
import com.example.backend.security.User;
import com.example.backend.security.service.JWTService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RepositoryManager repositoryManager;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

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


//    public String verify(UserLoginDTO userLoginDTO) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        userLoginDTO.getName(), userLoginDTO.getPassword()
//                )
//        );
//
//        if (authentication.isAuthenticated()) return jwtService.generateToken(
//                userLoginDTO.getName());
//        return null;
//    }

    
    public User registerUser(UserRegisterDTO userRegisterDTO) {

        if (repositoryManager.getUserRepository().existsByName(userRegisterDTO.getName())) {
            throw new UsernameAlreadyExistsException("User with name " + userRegisterDTO.getName() + " " +
                    "already exists");
        }

        User user = mapper.convertUserRegisterDTOToUser(userRegisterDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repositoryManager.getUserRepository().save(user);

    }
}

package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.dto.UserLoginDTO;
import com.example.backend.dto.UserRegisterDTO;
import com.example.backend.mapper.UserMapper;
import com.example.backend.security.User;
import com.example.backend.security.service.JWTService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = mapper.convertUserRegisterDTOToUser(userRegisterDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repositoryManager
                .getUserRepository()
                .save(user);
    }
}

package com.example.backend.controller;

import java.util.List;

import com.example.backend.dto.JwtResponseDTO;
import com.example.backend.dto.UserLoginDTO;
import com.example.backend.dto.UserRegisterDTO;
import com.example.backend.security.User;
import com.example.backend.security.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.UserDTO;
import com.example.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public UserDTO getUser(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        User user = userService.registerUser(userRegisterDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // чтобы легче было поменять проверку пользователя с имени на почту надо
    // чтобы везде использовался UserDetails а в UseerDetails возвращать почту
    // поменять чтобы пароль и имя не в боди реквеста в authorization
    // передвинуть в отдельный authController
//    @PostMapping("/login")
//    public ResponseEntity<JwtResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
//
//        JwtResponseDTO jwtResponseDTO = authService.authenticateUser(userLoginDTO);
//        return new ResponseEntity<>(jwtResponseDTO, HttpStatus.OK);
//
////        // нужна ли првоерка токена на null потому что если authentication manager
////        // не найдёт юзера то будет exception вроде как так что надо подумать тут
////        if (token == null) return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
////        else return new ResponseEntity<String>(token, HttpStatus.OK);
//    }
}

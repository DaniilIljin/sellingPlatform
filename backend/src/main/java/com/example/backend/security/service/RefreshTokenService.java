package com.example.backend.security.service;

import com.example.backend.dto.JwtResponseDTO;
import com.example.backend.model.RefreshToken;
import com.example.backend.repository.RefreshTokenRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    // надо ли доставать всего юзера
    // какую ошибку кидать тут
    // что делать если токе уже есть
    // использовать UserDetails вместо user
    public String createRefreshToken(String name) {

        User user = userRepository
                .findByNameEquals(name).orElseThrow(() -> new UsernameNotFoundException("User was" +
                        " not found"));



//        RefreshToken refreshToken;
//        User user = userRepository.findByNameEquals(name).orElseThrow(
//                () -> new UsernameNotFoundException("User was not found")
//        );
////        refreshToken.setUser(user);
//        Date issuedAt = new Date(System.currentTimeMillis());
//        Date expiryDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12);
//        String token = jwtService.generateRefreshToken(name, issuedAt, expiryDate);
//
////        refreshToken.setToken(passwordEncoder.encode(token));
////        refreshToken.setExpiryDate(expiryDate.toInstant());
////        refreshToken.setIssuedAt(issuedAt.toInstant());
//
//        Optional<RefreshToken> existingToken = refreshTokenRepository.findByUser(user);
//        if (existingToken.isPresent()) {
//            System.out.println("!!!");
//            refreshToken = existingToken.get();
//            refreshToken.setToken(token);
//            refreshToken.setIssuedAt(issuedAt.toInstant());
//            refreshToken.setExpiryDate(expiryDate.toInstant());
//        } else {
//            refreshToken = new RefreshToken();
//            refreshToken.setUser(user);
//            refreshToken.setToken(token);
//            System.out.println(expiryDate.toInstant() + "12321");
//            refreshToken.setExpiryDate(expiryDate.toInstant());
//            refreshToken.setIssuedAt(issuedAt.toInstant());
//        }
//        refreshTokenRepository.save(refreshToken);
//        RefreshToken t = refreshTokenRepository.findByToken(token).orElseThrow();
//        System.out.println(t.getToken());
//
//        return token;

        return null;
    }

    // сделать кастомный эксепшет если рефреш токен не найден
    public JwtResponseDTO validateRefreshToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository
                .findByToken(refreshToken)
                .orElseThrow(() -> new RuntimeException());
        if (token.getExpiryDate().isAfter(Instant.now())) {
            throw new RuntimeException();
        }
        User user = userRepository.findByNameEquals(jwtService.extractName(refreshToken))
                .orElseThrow(() -> new RuntimeException());
        if (jwtService.validateToken(refreshToken, user)) {
            String newRefreshToken = createRefreshToken(user.getName());
            String newAccessToken = jwtService.generateToken(user.getName());
            JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
            jwtResponseDTO.setRefreshToken(newRefreshToken);
            jwtResponseDTO.setAccessToken(newAccessToken);
            return jwtResponseDTO;
        } else return null;
    }
}

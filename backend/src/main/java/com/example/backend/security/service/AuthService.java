package com.example.backend.security.service;

import com.example.backend.dto.JwtResponseDTO;
import com.example.backend.dto.UserLoginDTO;
import com.example.backend.model.RefreshToken;
import com.example.backend.repository.RefreshTokenRepository;
import com.example.backend.security.User;
import com.example.backend.service.RepositoryManager;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final RepositoryManager repositoryManager;

    // надо ли возвращать null
    @Transactional
    public JwtResponseDTO authenticateUser(UserLoginDTO userLoginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDTO.getName(), userLoginDTO.getPassword())
        );

        if (authentication.isAuthenticated()) {

            User user = (User) authentication.getPrincipal();
            Optional<RefreshToken> existingToken = repositoryManager
                    .getRefreshTokenRepository()
                    .findByUser(user);

            existingToken.ifPresent(token -> repositoryManager
                    .getRefreshTokenRepository()
                    .delete(token));

            Date createdAt = new Date(System.currentTimeMillis());
            Date expiresAt = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12);
            String refreshToken = jwtService.generateRefreshToken(
                    userLoginDTO.getName(), createdAt, expiresAt);
            RefreshToken newToken = new RefreshToken();
            newToken.setUser(user);
            newToken.setToken(refreshToken);
            newToken.setIssuedAt(createdAt.toInstant());
            newToken.setExpiryDate(expiresAt.toInstant());

            repositoryManager
                    .getRefreshTokenRepository()
                    .save(newToken);

            JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
            String accessToken = jwtService.generateToken(userLoginDTO.getName());
            jwtResponseDTO.setAccessToken(accessToken);
            jwtResponseDTO.setRefreshToken(refreshToken);
            return jwtResponseDTO;

        }
        return null;
    }

    public JwtResponseDTO updateTokens(String refreshToken) {

        // или достать Optional объект и самому проверять
        RefreshToken existingRefreshToken  = repositoryManager
                .getRefreshTokenRepository()
                .findByToken(refreshToken).orElseThrow(() -> new RuntimeException("sf"));

        if (existingRefreshToken.getExpiryDate().isBefore(Instant.now())) {
            throw new RuntimeException("asdasd");
        }

        User user = existingRefreshToken.getUser();

        if (jwtService.validateToken(refreshToken, user)) {
            String accessToken = jwtService.generateToken(user.getUsername());
            Date createdAt = new Date(System.currentTimeMillis());
            Date expiresAt = new Date(System.currentTimeMillis());
            String newRefreshToken = jwtService.generateRefreshToken(user.getName(), createdAt, expiresAt);

            existingRefreshToken.setUser(user);
            existingRefreshToken.setIssuedAt(createdAt.toInstant());
            existingRefreshToken.setExpiryDate(expiresAt.toInstant());
            existingRefreshToken.setToken(newRefreshToken);

            repositoryManager
                    .getRefreshTokenRepository()
                    .save(existingRefreshToken);

            JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
            jwtResponseDTO.setAccessToken(accessToken);
            jwtResponseDTO.setRefreshToken(newRefreshToken);
            return jwtResponseDTO;
        } else throw new RuntimeException("asdad");
    }
}

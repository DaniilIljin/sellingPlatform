package com.example.backend.model;

import com.example.backend.security.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_hashed", nullable = false)
    private String token;

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    @Column(name = "creation_date", nullable = false)
    private Instant issuedAt;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}

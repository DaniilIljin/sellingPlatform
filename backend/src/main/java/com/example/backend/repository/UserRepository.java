package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.security.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameEquals(String name);

    Optional<User> findByEmailEquals(String email);

    Optional<User> findByPasswordEquals(String password);

    Optional<User> findByAddressEquals(String address);

    List<User> findAllByAdditionalInfoContains(String additionalInfo);
}

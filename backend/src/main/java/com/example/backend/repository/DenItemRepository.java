package com.example.backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Item;

import java.util.List;

@Repository
public class DenItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Item> findAll() {
        String jpql = "SELECT i FROM Item i";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }
}

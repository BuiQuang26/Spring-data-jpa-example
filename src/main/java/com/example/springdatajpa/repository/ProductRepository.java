package com.example.springdatajpa.repository;

import com.example.springdatajpa.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

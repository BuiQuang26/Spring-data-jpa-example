package com.example.springdatajpa.repository;
import com.example.springdatajpa.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}

package com.example.springdatajpa.controller;

import com.example.springdatajpa.models.Product;
import com.example.springdatajpa.models.Shop;
import com.example.springdatajpa.repository.ProductRepository;
import com.example.springdatajpa.repository.ShopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    private final ShopRepository shopRepository;

    private final ProductRepository productRepository;

    public ShopController(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createShop(Shop shop){
        Shop shop1 = shopRepository.save(shop);
        return new ResponseEntity<>(shop1, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        List<Shop> shops = shopRepository.findAll();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/add-product/{productID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@PathVariable Long id, @PathVariable Long productID){
        Product product = productRepository.findById(productID).orElseThrow();
        Shop shop = shopRepository.findById(id).orElseThrow();
        shop.getProducts().add(product);
        shopRepository.save(shop);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

}

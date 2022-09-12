package com.example.springdatajpa.controller;

import com.example.springdatajpa.models.Product;
import com.example.springdatajpa.models.Shop;
import com.example.springdatajpa.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProduct(Product product){
        Product p = productRepository.save(product);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

}

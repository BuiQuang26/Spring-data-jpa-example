package com.example.springdatajpa.controller;

import com.example.springdatajpa.models.Owner;
import com.example.springdatajpa.repository.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/owner")
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOwner(@RequestBody Owner owner){
        Owner owner1 = ownerRepository.save(owner);
        return new ResponseEntity<>(owner1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteOwner(@PathVariable Long id){
        ownerRepository.deleteById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOwners(){
        return new ResponseEntity<>(ownerRepository.findAll(), HttpStatus.OK);
    }
}

package com.josem.loginexample.login_example.controllers;

import com.josem.loginexample.login_example.entities.Address;
import com.josem.loginexample.login_example.services.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AdressController {

    @Autowired
    private AddressService service;

    @GetMapping("/getAddresses")
    public List<Address> list(){
        return (List<Address>) service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view (@PathVariable int id){
        Optional<Address> optionalAddress = service.findById(id);
        if(optionalAddress.isPresent()){
            return ResponseEntity.ok(optionalAddress.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Address> create(@RequestBody Address address){
        Address newAddress = service.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Address> modify(@PathVariable int id, @RequestBody Address address){
       Optional<Address> existingAddress = service.findById(id);
       if(existingAddress.isPresent()){
           Address modifiedAddress = existingAddress.get();
           modifiedAddress.setId(address.getId());
           modifiedAddress.setCity(address.getCity());
           modifiedAddress.setDoor(address.getDoor());
           modifiedAddress.setFloor(address.getFloor());
           modifiedAddress.setProvince(address.getProvince());
           modifiedAddress.setCountryCode(address.getCountryCode());
           modifiedAddress.setStreet(address.getStreet());
           modifiedAddress.setZipCode(address.getZipCode());

           return ResponseEntity.status(HttpStatus.CREATED).body(modifiedAddress);
       }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable int id){
        Address address = new Address();
        address.setId(id);
        Optional<Address> deletedAddress = service.delete(address);

        if(deletedAddress.isPresent()){
            return ResponseEntity.ok(deletedAddress.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}

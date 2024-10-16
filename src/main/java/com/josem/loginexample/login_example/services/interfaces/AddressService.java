package com.josem.loginexample.login_example.services.interfaces;

import com.josem.loginexample.login_example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    //Interfaz a implementar por CRUD direcciones

    List<Address> findAll();

    Optional<Address> findById(int id);

    Address save(Address address);

    Optional<Address> delete(Address address);
}

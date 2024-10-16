package com.josem.loginexample.login_example.repositories;

import com.josem.loginexample.login_example.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}

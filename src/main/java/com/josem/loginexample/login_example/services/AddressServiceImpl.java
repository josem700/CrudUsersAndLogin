package com.josem.loginexample.login_example.services;

import com.josem.loginexample.login_example.entities.Address;
import com.josem.loginexample.login_example.repositories.AddressRepository;
import com.josem.loginexample.login_example.services.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Address> findAll() {
        return (List<Address>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Address> findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Transactional
    @Override
    public Optional<Address> delete(Address address) {
        Optional<Address> optionalAddress = repository.findById(address.getId());
        optionalAddress.ifPresent(addressDb -> {
            repository.delete(addressDb);
        });
        return optionalAddress;
    }
}

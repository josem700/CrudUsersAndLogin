package com.josem.loginexample.login_example.services;

import com.josem.loginexample.login_example.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //Interfaz a implementar por el servicio de usuarios

    List<User> findAll();

    Optional<User> findById(int id);

    User save(User user);

    void delete(User user);
}

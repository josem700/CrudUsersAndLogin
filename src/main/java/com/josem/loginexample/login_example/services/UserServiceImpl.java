package com.josem.loginexample.login_example.services;

import com.josem.loginexample.login_example.entities.User;
import com.josem.loginexample.login_example.repositories.UserRepository;
import com.josem.loginexample.login_example.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public Optional<User> delete(User user) {
        //Obtener usuario borrado
        //Obtenemos el opcional
        Optional<User> userOptional = repository.findById(user.getId());
        userOptional.ifPresent(userDb -> {
            repository.delete(userDb);
        });
        return userOptional;
    }
}

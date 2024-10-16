package com.josem.loginexample.login_example.repositories;

import com.josem.loginexample.login_example.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

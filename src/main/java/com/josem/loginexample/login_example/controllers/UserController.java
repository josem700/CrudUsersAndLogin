package com.josem.loginexample.login_example.controllers;

import com.josem.loginexample.login_example.entities.User;
import com.josem.loginexample.login_example.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<User> list(){
        return userService.findAll();
    }

    //Le pasamos un parametro via path variable
    @GetMapping("/find/{id}")
    public ResponseEntity<?> view(@PathVariable int id){
        Optional<User> userOptional = userService.findById(id);
        //Si encuentra el usuario, devolvemos un status Ok y dentro del body, los datos
        if(userOptional.isPresent()){
            //Si no encuentra, lanzara una exception del tipo que corresponda
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        //Si no encuentra, devolvemos un 404
        return  ResponseEntity.notFound().build();
    }

    //Crear usuario
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        //Guarda usuario y responde con un Ok. Easy peasy.
        User userNew = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    //Modificar usuario
    @PutMapping("modify/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user){
        //Literalmente hace lo mismo que el metodo de arriba,
        //a tener en cuenta que save inserta, modifica y crea por lo que el id puede
        //venir nulo. Para evitar esto, se lo asignamos aqui.
        Optional<User> existingUser = userService.findById(id);

        if (existingUser.isPresent()) {
            // El usuario existe, actualizamos los datos
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setSurname(user.getSurname());
            updatedUser.setBirthDate(user.getBirthDate());
            updatedUser.setAge(user.getAge());
            updatedUser.setGender(user.getGender());

            // Guardar el usuario actualizado
            return ResponseEntity.ok(userService.save(updatedUser));
        } else {
            // El usuario con el ID especificado no existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Borrar Usuario
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        //Creo un objeto vacio al que le asigno el id
        User user = new User();
        user.setId(id);
        Optional<User> userOptional = userService.delete(user);
        if(userOptional.isPresent()){
            //Si no encuentra, lanzara una exception del tipo que corresponda
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        //Si no encuentra, devolvemos un 404
        return  ResponseEntity.notFound().build();
    }

}

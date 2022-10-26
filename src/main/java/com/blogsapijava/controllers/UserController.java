package com.blogsapijava.controllers;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.dtos.UserResponseDTO;
import com.blogsapijava.dtos.UserUpdateDTO;
import com.blogsapijava.interfaces.IUserService;
import com.blogsapijava.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    // como pegar dados basicos
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = service.findById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findById(@PathVariable String email) {
        User user = service.findByEmail(email);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();

        return ResponseEntity.ok(users);
    }

    // TODO: usar o URI ao criar um usuario
    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserRequestDTO userDTO) {
        User createdUser = service.create(userDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Valid @RequestBody UserUpdateDTO dataUserUpdate) {
        service.update(dataUserUpdate, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

package com.blogsapijava.controllers;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.interfaces.IUserService;
import com.blogsapijava.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = service.findById(id);

        return ResponseEntity.ok(user);
    }

    // TODO: usar o URI ao criar um usuario
    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserRequestDTO userDTO) {
        User createdUser = service.create(userDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}

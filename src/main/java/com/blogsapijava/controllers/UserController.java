package com.blogsapijava.controllers;

import com.blogsapijava.models.User;
import com.blogsapijava.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = service.findById(id);

        return ResponseEntity.ok(user);
    }
}

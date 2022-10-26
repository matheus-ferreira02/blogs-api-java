package com.blogsapijava.controllers;

import com.blogsapijava.dtos.CategoryRequestDTO;
import com.blogsapijava.interfaces.ICategoryService;
import com.blogsapijava.models.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable long id) {
        Category category = service.findById(id);

        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> category = service.findAll();

        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryRequestDTO categoryDTO) {
        Category category = service.create(categoryDTO);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}

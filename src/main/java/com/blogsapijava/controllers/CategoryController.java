package com.blogsapijava.controllers;

import com.blogsapijava.dtos.CategoryRequestDTO;
import com.blogsapijava.interfaces.ICategoryService;
import com.blogsapijava.models.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/name/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name) {
        Category category = service.findByName(name);

        return ResponseEntity.ok(category);
    }

    // TODO: retornar URI
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid CategoryRequestDTO categoryDTO) {
        Category category = service.create(categoryDTO);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

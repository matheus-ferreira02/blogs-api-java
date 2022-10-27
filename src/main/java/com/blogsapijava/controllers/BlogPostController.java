package com.blogsapijava.controllers;

import com.blogsapijava.dtos.BlogPostRequestDTO;
import com.blogsapijava.interfaces.IBlogPostService;
import com.blogsapijava.models.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/blogPost")
@RequiredArgsConstructor
public class BlogPostController {

    private final IBlogPostService service;

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> findById(@PathVariable long id) {
        BlogPost post = service.findById(id);

        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<BlogPost> create(@RequestBody @Valid BlogPostRequestDTO postDTO) {
        BlogPost newPost = service.create(postDTO);

        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

}
package com.blogsapijava.controllers;

import com.blogsapijava.interfaces.IBlogPostService;
import com.blogsapijava.models.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

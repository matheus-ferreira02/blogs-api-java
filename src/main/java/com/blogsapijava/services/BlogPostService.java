package com.blogsapijava.services;

import com.blogsapijava.dtos.BlogPostRequestDTO;
import com.blogsapijava.exceptions.NotFoundException;
import com.blogsapijava.interfaces.IBlogPostService;
import com.blogsapijava.models.BlogPost;
import com.blogsapijava.repositories.BlogPostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostService implements IBlogPostService {

    private final BlogPostRepo repo;
    private final UserService userService;

    @Override
    public BlogPost findById(long id) {
        Optional<BlogPost> blogPost = repo.findById(id);

        return blogPost.orElseThrow(() -> new NotFoundException("Post not found"));
    }

    @Override
    public BlogPost create(BlogPostRequestDTO post) {
        userService.findById(post.getUserId());

        BlogPost newPost = new BlogPost();
        newPost.setContent(post.getContent());
        newPost.setTitle(post.getTitle());

        return repo.save(newPost);
    }

    @Override
    public List<BlogPost> findAll() {
        return null;
    }

    @Override
    public void update(BlogPost post) {

    }

    @Override
    public void delete(long id) {

    }
}

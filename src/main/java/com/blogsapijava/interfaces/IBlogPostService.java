package com.blogsapijava.interfaces;

import com.blogsapijava.dtos.BlogPostRequestDTO;
import com.blogsapijava.models.BlogPost;

import java.util.List;

public interface IBlogPostService {
    BlogPost findById(long id);
    BlogPost create(BlogPostRequestDTO post);
    List<BlogPost> findAll();
    void update(BlogPost post);
    void delete(long id);
}

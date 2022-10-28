package com.blogsapijava.interfaces;

import com.blogsapijava.dtos.BlogPostRequestDTO;
import com.blogsapijava.dtos.BlogPostUpdateDTO;
import com.blogsapijava.models.BlogPost;

import java.util.List;

public interface IBlogPostService {
    BlogPost findById(long id);
    BlogPost create(BlogPostRequestDTO post);
    List<BlogPost> findAll();
    void update(BlogPostUpdateDTO dataPostUpdate, long id);
    void delete(long id);
}

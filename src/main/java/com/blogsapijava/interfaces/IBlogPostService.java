package com.blogsapijava.interfaces;

import com.blogsapijava.models.BlogPost;

import java.util.List;

public interface IBlogPostService {
    BlogPost findById(long id);
    BlogPost create(BlogPost post);
    List<BlogPost> findAll();
    void update(BlogPost post);
    void delete(long id);
}

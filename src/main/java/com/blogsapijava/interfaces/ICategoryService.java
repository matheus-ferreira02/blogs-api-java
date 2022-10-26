package com.blogsapijava.interfaces;

import com.blogsapijava.models.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(long id);
    Category findByName(String name);
    Category create(Category category);
    List<Category> findAll();
    void delete(long id);
}

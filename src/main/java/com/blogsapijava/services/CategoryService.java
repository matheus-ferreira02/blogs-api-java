package com.blogsapijava.services;

import com.blogsapijava.dtos.CategoryRequestDTO;
import com.blogsapijava.exceptions.FieldExistsException;
import com.blogsapijava.exceptions.NotFoundException;
import com.blogsapijava.interfaces.ICategoryService;
import com.blogsapijava.models.Category;
import com.blogsapijava.repositories.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo repo;

    @Override
    public Category findById(long id) {
        Optional<Category> category = repo.findById(id);

        return category.orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public Category findByName(String name) {
        Optional<Category> category = repo.findByName(name);

        return category.orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public Category create(CategoryRequestDTO categoryDTO) {
        this.verifyExistingCategory(categoryDTO.getName());

        Category category = new Category();
        category.setName(categoryDTO.getName());

        return repo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(long id) {
        this.findById(id);

        repo.deleteById(id);
    }

    private void verifyExistingCategory(String name) {
        Optional<Category> category = repo.findByName(name);

        if (category.isPresent()) throw new FieldExistsException("Category already exists");
    }
}

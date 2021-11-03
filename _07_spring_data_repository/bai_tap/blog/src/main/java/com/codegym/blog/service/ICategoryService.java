package com.codegym.blog.service;

import com.codegym.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void update(Category category);
    void remove(Long id);
    Category findById(Long id);
}

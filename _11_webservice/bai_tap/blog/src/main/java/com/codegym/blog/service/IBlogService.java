package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
    void update(Blog blog);
    void remove(Long id);
    Blog findById(Long id);
    Page<Blog> searchAll(Pageable pageable, String title, String idCategory);

    Page<Blog> findAllSrarchName(Pageable pageable, String keyordValue);
}

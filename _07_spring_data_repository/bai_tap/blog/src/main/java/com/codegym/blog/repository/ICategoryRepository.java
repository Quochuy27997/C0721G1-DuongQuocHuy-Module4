package com.codegym.blog.repository;

import com.codegym.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICategoryRepository extends JpaRepository<Category,Long> {


}

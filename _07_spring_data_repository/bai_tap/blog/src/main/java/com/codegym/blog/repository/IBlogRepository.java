package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query(value="select * from blog where title like :title and category_id like :id",nativeQuery=true)
    Page<Blog> searchAll(Pageable pageable, @Param("title") String title,@Param("id") String idCategory);
}

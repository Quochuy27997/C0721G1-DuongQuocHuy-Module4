package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IBlogService iBlogService;

    @GetMapping("/category")
    public List<Category> getListCategory() {
        return iCategoryService.findAll();
    }

    @GetMapping("/blog/{page}/{size}")
    public ResponseEntity<?> getListBlog(@PathVariable int page, @PathVariable int size) {
        Page<Blog> blogPage = iBlogService.findAll(PageRequest.of(page, size));


        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/blog/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
//        Page<Blog> blogPage=iBlogService.findAll(PageRequest.of(page,size));
        iBlogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PatchMapping("/blog/update")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
   iBlogService.update(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    

}

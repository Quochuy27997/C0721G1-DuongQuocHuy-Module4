package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CategoryRestController {
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/category")
    public List<Category> getListCategory() {
        return iCategoryService.findAll();
    }
}

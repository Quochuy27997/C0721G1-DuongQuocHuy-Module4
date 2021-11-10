package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/cate")
    public ModelAndView listCategory() {
        Iterable<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView save(@ModelAttribute Category category) {
        iCategoryService.save(category);
        Iterable<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

        @GetMapping("/edit-category/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Category category = iCategoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;

    }

    @PostMapping("/edit-category")
    public ModelAndView update(@ModelAttribute Category category) {
        iCategoryService.update(category);
        Iterable<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        iCategoryService.remove(id);
        Iterable<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }
}

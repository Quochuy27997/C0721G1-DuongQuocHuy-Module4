package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class BlogController {
    @Autowired
    ICategoryService iCategoryService;

    @ModelAttribute("categoryList")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blog")
    public ModelAndView listBlog(@PageableDefault(value = 3, sort = "date", direction = Sort.Direction.DESC)
                                         Pageable pageable, @RequestParam(value = "title", defaultValue = "", required = false) String title,
                                 @RequestParam(value = "idCategory", defaultValue = "", required = false) String categoryId) {
        Page<Blog> blogList = iBlogService.searchAll(pageable,title,categoryId);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("title" ,title);
        modelAndView.addObject("categoryId" ,categoryId);
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView save(@ModelAttribute Blog blog, @PageableDefault(value = 3) Pageable pageable) {
        blog.setDate(new Date(System.currentTimeMillis()));
        iBlogService.save(blog);
        Iterable<Blog> blogList = iBlogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;

    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute Blog blog, @PageableDefault(value = 3) Pageable pageable) {
        blog.setDate(new Date(System.currentTimeMillis()));
        iBlogService.update(blog);
        Iterable<Blog> blogList = iBlogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView delete(@PathVariable Long id, @PageableDefault(value = 3) Pageable pageable) {
        iBlogService.remove(id);
        Iterable<Blog> blogList = iBlogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", iBlogService.findById(id));
        return modelAndView;
    }
}

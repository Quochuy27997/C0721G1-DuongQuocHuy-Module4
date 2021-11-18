package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.ICustomerService;
import com.codegym.casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeList")
    public Iterable<CustomerType> customerTypes() {
        return iCustomerTypeService.findAll();
    }

    @Autowired
    ICustomerService iCustomerService;

    @ModelAttribute("customerList")
    public Iterable<Customer> customers(){return iCustomerService.findAll();}
    @GetMapping("")
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,@RequestParam(value = "name", defaultValue = "", required = false) String name,
                                     @RequestParam(value = "idCustomerType", defaultValue = "", required = false) String customerTypeId) {
        Page<Customer> customerList = iCustomerService.searchAll(pageable,name,customerTypeId);

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("name", name);
        modelAndView.addObject("customerTypeId", customerTypeId);
        modelAndView.addObject("customerList", customerList);

        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView save(@ModelAttribute Customer customer) {

        iCustomerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Customer customer = iCustomerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;

    }

    @PostMapping("/edit-customer")
    public ModelAndView update(@ModelAttribute Customer customer) {

        iCustomerService.update(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView delete(@PathVariable Long id, @PageableDefault(value = 3) Pageable pageable) {
        iCustomerService.delete(id);
        Iterable<Customer> customerList = iCustomerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

}

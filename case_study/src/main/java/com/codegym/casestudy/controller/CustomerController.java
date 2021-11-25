package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.CustomerDto;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.ICustomerService;
import com.codegym.casestudy.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

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
        CustomerDto customerDto=new CustomerDto();
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView save(@ModelAttribute  @Validated CustomerDto customerDto, BindingResult bindingResult) {
        List<Customer> customerList = iCustomerService.findAll();
        customerDto.setCustomerList(customerList);
        new CustomerDto().validate(customerDto, bindingResult);
//        iCustomerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/create");

        if (!bindingResult.hasFieldErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            modelAndView.addObject("message", "Add Completed!");
        }

//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Customer customer = iCustomerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        modelAndView.addObject("customerDto", customerDto);

        return modelAndView;

    }

    @PostMapping("/edit-customer")
    public ModelAndView update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult) {

        List<Customer> customerList = iCustomerService.findAll();
        for(int i=0;i<customerList.size();i++){
            if(customerList.get(i).getId()== customerDto.getId()){
                customerList.remove(customerList.get(i));
            }
        }
        customerDto.setCustomerList(customerList);
        new CustomerDto().validate(customerDto, bindingResult);
//        iCustomerService.update(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        if (!bindingResult.hasFieldErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            modelAndView.addObject("message", "Edit Completed!");
        }
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id, @PageableDefault(value = 3) Pageable pageable) {
        iCustomerService.delete(id);
        Iterable<Customer> customerList = iCustomerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

}

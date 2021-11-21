package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IAppServiceService iAppServiceService;
//    @ModelAttribute("contractList")
//    public Iterable<Contract> contracts() {
//        return iContractService.findAll();
//    }
    @ModelAttribute("customerList")
    public Iterable<Customer> customers() {
        return iCustomerService.findAll();
    }
    @ModelAttribute("employeeList")
    public Iterable<Employee> employees() {
        return iEmployeeService.findAll();
    }
    @ModelAttribute("appServiceList")
    public Iterable<AppService> appServices(){return iAppServiceService.findAll();}

    @GetMapping("")
    public ModelAndView listContract(@PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contractList = iContractService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/contract/list");

        modelAndView.addObject("contractList", contractList);

        return modelAndView;
    }

    @GetMapping("/create-contract")
    public ModelAndView showBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/create-contract")
    public ModelAndView save(@ModelAttribute Contract contract) {

        iContractService.save(contract);

        ModelAndView modelAndView = new ModelAndView("/contract/create");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}

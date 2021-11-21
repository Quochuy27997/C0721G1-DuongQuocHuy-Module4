package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IDivisionService iDivisionService;

    @ModelAttribute("divisionList")
    public Iterable<Division> divisions() {
        return iDivisionService.findAll();
    }

    @Autowired
    IEducationDegreeService iEducationDegreeService;

    @ModelAttribute("educationDegreeList")
    public Iterable<EducationDegree> educationDegrees() {
        return iEducationDegreeService.findAll();
    }

    @Autowired
    IPositionService iPositionService;

    @ModelAttribute("positionList")
    public Iterable<Position> positions(){return iPositionService.findAll();}

    @Autowired
    IEmployeeService iEmployeeService;

    @ModelAttribute("employeeList")
    public Iterable<Employee> employees(){return iEmployeeService.findAll();}

    @GetMapping("")
    public ModelAndView listEmployee(@PageableDefault(value = 3) Pageable pageable,@RequestParam(value = "name", defaultValue = "", required = false) String name,
                                     @RequestParam(value = "idPosition", defaultValue = "", required = false) String positionId,@RequestParam(value = "idEducationDegree", defaultValue = "", required = false) String educationDegreeid,
                                     @RequestParam(value = "idDivision", defaultValue = "", required = false) String divisionId) {
//        Page<Customer> customerList = iCustomerService.searchAll(pageable,name,customerTypeId);
        Page<Employee> employeeList = iEmployeeService.searchAll(pageable,name,positionId,educationDegreeid,divisionId);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("name", name);
        modelAndView.addObject("positionId", positionId);
        modelAndView.addObject("educationDegreeid", educationDegreeid);
        modelAndView.addObject("divisionId", divisionId);

        modelAndView.addObject("employeeList", employeeList);

        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView save(@ModelAttribute Employee employee) {

        iEmployeeService.save(employee);

        ModelAndView modelAndView = new ModelAndView("/employee/create");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Employee employee = iEmployeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;

    }

    @PostMapping("/edit-employee")
    public ModelAndView update(@ModelAttribute Employee employee) {

        iEmployeeService.update(employee);

        ModelAndView modelAndView = new ModelAndView("/employee/edit");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
    @GetMapping("/delete-employee/{id}")
    public ModelAndView delete(@PathVariable Long id, @PageableDefault(value = 3) Pageable pageable) {
        iEmployeeService.delete(id);
        Iterable<Employee> employeeList = iEmployeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
    }

}

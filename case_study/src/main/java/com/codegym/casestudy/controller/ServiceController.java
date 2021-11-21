package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.IAppServiceService;
import com.codegym.casestudy.service.ICustomerTypeService;
import com.codegym.casestudy.service.IRentTypeService;
import com.codegym.casestudy.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IAppServiceService iAppServiceService;
    @Autowired
    IServiceTypeService iServiceTypeService;
    @Autowired
    IRentTypeService iRentTypeService;
    @ModelAttribute("rentTypeList")
    public Iterable<RentType> rentTypes() {
        return iRentTypeService.findAll();
    }
    @ModelAttribute("serviceTypeList")
    public Iterable<ServiceType> serviceTypes() {
        return iServiceTypeService.findAll();
    }
    @ModelAttribute("appServiceList")
    public Iterable<AppService> appServices(){return iAppServiceService.findAll();}

    @GetMapping("")
    public ModelAndView listAppService(@PageableDefault(value = 3) Pageable pageable) {
        Page<AppService> appServiceList = iAppServiceService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/service/list");

        modelAndView.addObject("appServiceList", appServiceList);

        return modelAndView;
    }

    @GetMapping("/create-service")
    public ModelAndView showBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("appService", new AppService());
        return modelAndView;
    }

    @PostMapping("/create-service")
    public ModelAndView save(@ModelAttribute AppService service) {

        iAppServiceService.save(service);

        ModelAndView modelAndView = new ModelAndView("/service/create");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}

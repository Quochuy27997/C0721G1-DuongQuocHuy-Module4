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
@RequestMapping("/contractdetail")
public class ContractDetailController {
    @Autowired
    IContractService iContractService;
    @Autowired
    IAttachServiceService iAttachServiceService;
    @Autowired
    IContractDetailService iContractDetailService;

    @ModelAttribute("contractList")
    public Iterable<Contract> contracts() {
        return iContractService.findAll();
    }
    @ModelAttribute("attachServiceList")
    public Iterable<AttachService> attachServices() {
        return iAttachServiceService.findAll();
    }
    @ModelAttribute("contractDetailList")
    public Iterable<ContractDetail> contractDetails() {
        return iContractDetailService.findAll();
    }

    @GetMapping("")
    public ModelAndView listContractDetail(@PageableDefault(value = 3) Pageable pageable) {
        Page<ContractDetail> contractDetailList = iContractDetailService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/contractdetail/list");

        modelAndView.addObject("contractDetailList", contractDetailList);

        return modelAndView;
    }

    @GetMapping("/create-contractdetail")
    public ModelAndView showBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/contractdetail/create");
        modelAndView.addObject("contractDetail", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/create-contractdetail")
    public ModelAndView save(@ModelAttribute ContractDetail contractDetail) {

        iContractDetailService.save(contractDetail);

        ModelAndView modelAndView = new ModelAndView("/contractdetail/create");
//        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}

package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanwidchController {

    @RequestMapping( "/sandwich")
    public String save( Model model, @RequestParam(value="condiment") String[] condiment) {
        model.addAttribute("condiment", condiment);
        return "result";
    }
}

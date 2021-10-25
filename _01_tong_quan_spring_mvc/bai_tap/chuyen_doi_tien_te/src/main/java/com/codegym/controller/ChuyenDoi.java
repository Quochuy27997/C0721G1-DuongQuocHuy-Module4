package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChuyenDoi {
    @RequestMapping("/chuyendoi")
    public String displayList(HttpServletRequest request, Model model) {
        double usd= Double.parseDouble(request.getParameter("usd"));
        double vnd = usd*23000;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "file";
    }
}

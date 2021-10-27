package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class Calculatorcontroller {



    @GetMapping("/calculator")
    public String Calculator(@RequestParam(name = "firstNumber") double firstNumber,
                             @RequestParam (name = "secondNumber") double secondNumber,
                             @RequestParam (name = "calculate") String calculate,
            Model model){
        double result = 0;
        switch (calculate) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("khong the chia cho 0");
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                throw new UnsupportedOperationException("khong ho tro.");
        }
        model.addAttribute("result", result);
        return "result";

    }
}

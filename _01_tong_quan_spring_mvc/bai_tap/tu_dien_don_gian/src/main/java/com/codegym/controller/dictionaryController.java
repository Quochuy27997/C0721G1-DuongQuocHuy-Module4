package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {
    @RequestMapping("/dictionary")
    public String dictionaryShowList(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String> dictonary = new HashMap<>();
        dictonary.put("one", "một");
        dictonary.put("two", "hai");
        dictonary.put("three", "ba");
        dictonary.put("four", "bốn");
        dictonary.put("five", "năm");
        dictonary.put("six", "sáu");
        dictonary.put("seven", "bảy");
        dictonary.put("eight", "tám");
        dictonary.put("nine", "chín");
        dictonary.put("ten", "mười");
        String word = request.getParameter("word");
        String result = word + " không tìm thấy !";
        for (String key : dictonary.keySet()) {
            if (word.equals(key)) {
                result = dictonary.get(key);
                break;
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("word", word);

        return "result";
    }
}

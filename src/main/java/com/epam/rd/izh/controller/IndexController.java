package com.epam.rd.izh.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {

        if (!model.containsAttribute("categories")) {
            model.addAttribute("categories", new ArrayList<>());
        }

        model.addAttribute("message", "Пользователь: " + authentication.getName());
        return "index";
    }
}

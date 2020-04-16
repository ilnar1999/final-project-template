package com.epam.rd.izh.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {

        if (!model.containsAttribute("authorized_user_name")) {
            model.addAttribute("authorized_user_name", authentication.getName());
        }

        return "index";
    }
}

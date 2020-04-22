package com.epam.rd.izh.controller;

import com.epam.rd.izh.service.AuthorizedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    AuthorizedUserService userService;

    @GetMapping("/admin")
    public String admin(Model model, Authentication authentication) {
        if (!model.containsAttribute("authorized_user_name")) {
            model.addAttribute("authorized_user_name", authentication.getName());
        }
        if (!model.containsAttribute("users")) {
            model.addAttribute("users", userService.getAllUsers());
        }
        return "/admin";
    }

    @PostMapping("/admin/delete-user")
    public String deleteUser(@RequestParam(name = "user-id") Long id) {
        if (id != null) {
            userService.deleteUserById(id);
        }
        return "redirect:/admin";
    }
}

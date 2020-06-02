package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.service.AuthorizedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AuthorizedUserService userService;

    @GetMapping("/admin")
    public String admin(@RequestParam(name = "substring_of_login", defaultValue = "") String substringOfLogin,
                        Model model, Authentication authentication) {
        List<AuthorizedUser> users = userService.getAllUsersBySubstringOfLogin(substringOfLogin);

        model.addAttribute("authorized_user_name", authentication.getName());
        model.addAttribute("current_user", userService.getUserByLogin(authentication.getName()));
        model.addAttribute("users", users);

        return "/admin";
    }

    @PostMapping("/admin/delete-user")
    public String deleteUser(@RequestParam(name = "user-id") Long id) {
        if (id != null) {
            userService.deleteUserById(id);
        }
        return "redirect:/admin";
    }

    @PostMapping("/admin/set-role-to-user")
    public String setRoleToUser(@RequestParam(name = "user-id") Long userId,
                                @RequestParam(name = "role") String roleName,
                                @RequestParam(name = "action") String action) {
        if (action.equalsIgnoreCase("add")) {
            userService.addRoleToUserByUserIdAndRoleName(userId, roleName);
        } else if (action.equalsIgnoreCase("delete")) {
            userService.deleteUserRoleByUserIdAndRoleName(userId, roleName);
        }

        return "redirect:/admin";
    }
}

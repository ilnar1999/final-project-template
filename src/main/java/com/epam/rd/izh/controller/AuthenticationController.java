package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.RegisteredUser;

import javax.validation.Valid;

import com.epam.rd.izh.service.AuthorizedUserServiceMapper;
import com.epam.rd.izh.service.AuthorizedUserService;
import com.epam.rd.izh.validation.RegisteredUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthenticationController {

    @Autowired
    AuthorizedUserService userService;
    @Autowired
    AuthorizedUserServiceMapper mapper;
    @Autowired
    RegisteredUserValidator registeredUserValidator;


    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("error_login_placeholder", "Логин или пароль введены неверно");
        }
        return "/login";
    }


    @GetMapping("/registration")
    public String viewRegistration(Model model, @RequestParam(name = "error_login_placeholder", required = false) String errorLoginPlaceholder,
                                                @RequestParam(name = "error_passwordConfirm_placeholder", required = false) String errorPasswordConfirmPlaceholder,
                                                @RequestParam(name = "error_password_placeholder", required = false) String errorPasswordPlaceholder) {
        if (!model.containsAttribute("registrationForm")) {
            model.addAttribute("registrationForm", new RegisteredUser());
        }
        model.addAttribute("error_login_placeholder", errorLoginPlaceholder);
        model.addAttribute("error_password_placeholder", errorPasswordPlaceholder);
        model.addAttribute("error_passwordConfirm_placeholder", errorPasswordConfirmPlaceholder);
        return "/registration";
    }

    @PostMapping("/registration/proceed")
    public String processRegistration(@Valid @ModelAttribute("registrationForm") RegisteredUser registeredUser,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        registeredUserValidator.validate(registeredUser, bindingResult);
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> redirectAttributes.addAttribute(error.getObjectName(), error.getDefaultMessage()));
            return "redirect:/registration";
        }

        userService.saveUser(mapper.mapRegisteredUserToAuthorizedUser(registeredUser));

        return "redirect:/login";
    }

}
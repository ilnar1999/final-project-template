package com.epam.rd.izh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/403")
    public String error403() {
        return "error";
    }
}

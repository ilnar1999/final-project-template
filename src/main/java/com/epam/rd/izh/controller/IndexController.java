package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.CreatedCar;
import com.epam.rd.izh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String index(@RequestParam(name = "error_category_name", required = false) String ErrorCategoryName,
                        @RequestParam(name = "error_car_exists", required = false) String ErrorCarExists,
                        @RequestParam(name = "category_id", required = false) String categoryId,
                        Authentication authentication, Model model) {

        if (ErrorCategoryName != null) {
            model.addAttribute("error_category_name", "Категория с таким названием уже существует");
        }
        if (ErrorCarExists != null) {
            model.addAttribute("error_car_exists", "Автомобиль с такими производителем и моделью уже существует");
            model.addAttribute("category_id", categoryId);
        }
        if (!model.containsAttribute("createdCar")) {
            model.addAttribute("createdCar", new CreatedCar());
        }
        if (!model.containsAttribute("authorized_user_name")) {
            model.addAttribute("authorized_user_name", authentication.getName());
        }
        if (!model.containsAttribute("categories")) {
            model.addAttribute("categories", categoryService.getAllCategories());
        }

        return "/index";
    }
}

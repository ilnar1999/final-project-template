package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.CreatedCar;
import com.epam.rd.izh.service.CarService;
import com.epam.rd.izh.service.CarServiceMapper;
import com.epam.rd.izh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EditController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    CarService carService;
    @Autowired
    CarServiceMapper carMapper;


    @PostMapping("/edit/delete-category")
    public String deleteCategory(@RequestParam(name = "category-id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/";
    }

    @PostMapping("/edit/create-category")
    public String createCategory(@RequestParam(name = "category-name") String name, RedirectAttributes redirectAttributes) {
        if (!categoryService.saveCategoryByName(name)) {
            redirectAttributes.addAttribute("error_category_name", "Категория с таким названием уже существует");
        }

        return "redirect:/";
    }

    @PostMapping("/edit/create-car")
    public String createCar(@ModelAttribute("createdCar") CreatedCar createdCar) {
        carService.saveCar(carMapper.mapCreatedCarToCar(createdCar));

        return "redirect:/";
    }
}

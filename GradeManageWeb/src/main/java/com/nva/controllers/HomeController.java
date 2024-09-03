/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.controllers;

import com.nva.service.CategoryService;
import com.nva.service.SubjectService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguye
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService cateService;

    @Autowired
    private SubjectService subService;

    @ModelAttribute
    public void commAttrs(Model model) {
        model.addAttribute("categories", this.cateService.getCates());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("subjects", subService.getSubjects(params));

        return "home";
    }
}

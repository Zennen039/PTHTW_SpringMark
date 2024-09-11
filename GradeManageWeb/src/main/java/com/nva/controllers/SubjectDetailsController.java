/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.controllers;

import com.nva.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguye
 */
@Controller
public class SubjectDetailsController {

    @Autowired
    private UserService userService;

    @RequestMapping("/subjectdetails")
    public String SubjectDetails(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("user", this.userService.getAllUser(params));

        return "subjectdetails";
    }
}

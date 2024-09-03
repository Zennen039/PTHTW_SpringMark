/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.controllers;

import com.nva.pojo.Subject;
import com.nva.service.SubjectService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nguye
 */
@Controller
public class SubjectController {

    @Autowired
    private SubjectService subService;

    @GetMapping("/subjects")
    public String createView(Model model) {
        model.addAttribute("subject", new Subject());

        return "subjects";
    }

    @PostMapping("/subjects")
    public String createView(Model model,
            @ModelAttribute(value = "subject") @Valid Subject sj, BindingResult br) {

        if (br.hasErrors()) {
            return "subjects";
        }

        try {
            this.subService.addOrUpdate(sj);

            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "subjects";
    }

    @GetMapping("/subjects/{subjectId}")
    public String detailsView(Model model, @PathVariable(value = "subjectId") int id) {
        model.addAttribute("subject", this.subService.getSubjectById(id));

        return "subjects";
    }
}

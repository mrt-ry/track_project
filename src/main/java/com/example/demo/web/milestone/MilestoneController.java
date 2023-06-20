package com.example.demo.web.milestone;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.milestone.MilestoneService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("milestoneList", milestoneService.findAll());
        return "milestones/list";
    }
    
    @GetMapping("/creationForm") 
    public String showCreationForm(@ModelAttribute MilestoneForm form) {
        return "milestones/creationForm";
    }

    @PostMapping // POSTリクエストのアノテーション
    public String create(MilestoneForm form, Model model) {
        milestoneService.create(form.getMilestone(), form.getDescription());
        return showList(model);
    }
}

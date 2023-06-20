package com.example.demo.web.milestone;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.milestone.MilestoneService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/milestones")
    public String showList(Model model) {
        model.addAttribute("milestoneList", milestoneService.findAll());
        return "milestones/list";
    }

}

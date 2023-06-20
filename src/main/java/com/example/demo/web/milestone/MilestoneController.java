package com.example.demo.web.milestone;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.milestone.MilestoneEntity;

@Controller
public class MilestoneController {

    @GetMapping("/milestones")
    public String showList(Model model) {

        var milestoneList = List.of(
                new MilestoneEntity(1, "1", "1"),
                new MilestoneEntity(2, "2", "2"),
                new MilestoneEntity(3, "3", "3"));

        model.addAttribute("milestoneList", milestoneList);

        return "milestones/list";

    }

}

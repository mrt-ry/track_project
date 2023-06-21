package com.example.demo.web.milestone;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.domain.milestone.MilestoneService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    // milestonesリストの表示
    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("milestoneList", milestoneService.findAll());
        return "milestones/list";
    }
    
    // milestone作成フォームを表示
    @GetMapping("/creationForm") 
    public String showCreationForm(@ModelAttribute MilestoneForm form) {
        return "milestones/creationForm";
    }

    // POSTリクエスト
    @PostMapping 
    @Transactional 
    public String create(@Validated MilestoneForm milestoneForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return showCreationForm(milestoneForm);
        }
        milestoneService.create(milestoneForm.getMilestone(), milestoneForm.getDescription());
        return "redirect:/milestones";
    }

    // 詳細ページ
    @GetMapping("/{id}")
    public String displayView(@PathVariable Long id, Model model) {
        model.addAttribute("milestone", milestoneService.findData(id));
        return "milestones/detail";
  }
}

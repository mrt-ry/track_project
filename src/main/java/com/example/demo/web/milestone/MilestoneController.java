package com.example.demo.web.milestone;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.User.UserDetailService;
import com.example.demo.domain.milestone.MilestoneService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    private final UserDetailService userDetailService;

    // milestonesリストの表示
    // @GetMapping()
    // public String showList(Model model, String sort) {
    // // model.addAttribute("milestoneList", milestoneService.findAll());
    // if (sort != null) {
    // model.addAttribute("milestoneList", milestoneService.sortDesc());
    // } else

    // {
    // model.addAttribute("milestoneList", milestoneService.findAll());
    // }

    // org.springframework.security.core.Authentication authentication =
    // SecurityContextHolder.getContext()
    // .getAuthentication();
    // String username = authentication
    // .getName();
    // model.addAttribute("user", userDetailService.getuser(username));
    // return "milestones/list";
    // }

    // milestone作成フォームを表示
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute MilestoneForm form, Model model, HttpSession session) {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = authentication.getName();
        model.addAttribute("user", userDetailService.getuser(username));
        model.addAttribute("project", (String) session.getAttribute("projectId"));
        return "milestones/creationForm";
    }

    // POSTリクエスト
    @PostMapping
    @Transactional
    public String create(@Validated MilestoneForm milestoneForm, BindingResult bindingResult, HttpSession session) {

        milestoneService.create(milestoneForm.getMilestone(), milestoneForm.getStatus(), milestoneForm.getPriority(),
                milestoneForm.getDate(), milestoneForm.getCategory(), (String) session.getAttribute("projectId"));

        return "redirect:/milestones/project=" + (String) session.getAttribute("projectId");
    }

    // 詳細ページ
    @GetMapping("/{id}")
    public String displayView(HttpSession session, @ModelAttribute MilestoneForm form, @PathVariable Long id,
            Model model) {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = authentication.getName();
        model.addAttribute("user", userDetailService.getuser(username));
        model.addAttribute("milestone", milestoneService.findData(id));
        model.addAttribute("id", id);
        model.addAttribute("project", (String) session.getAttribute("projectId"));
        model.addAttribute("milestoneForm", form);
        return "milestones/detail";
    }

    // マイルストーンの削除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model, HttpSession session) {
        milestoneService.deleteById(id);
        return "redirect:/milestones/project=" + (String) session.getAttribute("projectId");
    }

    @GetMapping("/update")
    public String update(@ModelAttribute MilestoneForm form, Model model) {
        model.addAttribute("milestoneForm", form);
        return "milestones/update";
    }

    // マイルストーンの編集
    @PostMapping("/update/{id}")
    public String update(@Validated MilestoneForm milestoneForm, @PathVariable Long id, BindingResult bindingResult,
            HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "redirect:/milestones/project=" + (String) session.getAttribute("projectId");
        }
        milestoneService.update(id, milestoneForm.getMilestone(),
                milestoneForm.getStatus(), milestoneForm.getPriority(),
                milestoneForm.getDate(), milestoneForm.getCategory());

        return "redirect:/milestones/project=" + (String) session.getAttribute("projectId");
    }

    @GetMapping("/project={projectid}")
    public String showListProject1(Model model, @PathVariable String projectid, HttpSession session, String sort) {
        model.addAttribute("milestoneList", milestoneService.findProject(projectid));
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = authentication.getName();
        session.setAttribute("projectId", projectid);
        model.addAttribute("projectimg", milestoneService.getProjectimg(projectid));
        model.addAttribute("user", userDetailService.getuser(username));
        model.addAttribute("project", projectid);
        // if (sort != null) {
        // model.addAttribute("milestoneList", milestoneService.sortDesc(projectid));
        // } else

        // {
        // model.addAttribute("milestoneList", milestoneService.findProject(projectid));
        // }
        model.addAttribute("projectName", milestoneService.getProjectName(projectid));
        milestoneService.getMilestoneCategory(projectid);

        model.addAttribute("proCategory", milestoneService.getMilestoneCategory(projectid));
        model.addAttribute("projectimg",
                milestoneService.getProjectimg((String) session.getAttribute("projectId")));
        model.addAttribute("proStatus", milestoneService.getMilestoneStatus(projectid));
        model.addAttribute("projectdetail",
                milestoneService.getProjectdetail((String) session.getAttribute("projectId")));
        return "milestones/list";
    }

    @GetMapping("")
    public String showListProject1sort(Model model, HttpSession session, String sortdata, String sorttype) {
        model.addAttribute("milestoneList", milestoneService.findProject((String) session.getAttribute("projectId")));
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = authentication.getName();
        model.addAttribute("user", userDetailService.getuser(username));
        model.addAttribute("project", (String) session.getAttribute("projectId"));
        if (sortdata != null) {
            model.addAttribute("milestoneList",
                    milestoneService.sort(sortdata, sorttype, (String) session.getAttribute("projectId")));
        } else {
            model.addAttribute("milestoneList",
                    milestoneService.findProject((String) session.getAttribute("projectId")));
        }
        model.addAttribute("projectName", milestoneService.getProjectName((String) session.getAttribute("projectId")));
        model.addAttribute("projectimg", milestoneService.getProjectimg((String) session.getAttribute("projectId")));
        milestoneService.getMilestoneCategory((String) session.getAttribute("projectId"));
        model.addAttribute("proCategory",
                milestoneService.getMilestoneCategory((String) session.getAttribute("projectId")));
        model.addAttribute("proStatus",
                milestoneService.getMilestoneStatus((String) session.getAttribute("projectId")));
        model.addAttribute("projectdetail",
                milestoneService.getProjectdetail((String) session.getAttribute("projectId")));
        return "milestones/list";
    }

}
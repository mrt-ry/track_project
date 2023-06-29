package com.example.demo.web;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.User.UserDetailService;
import com.example.demo.domain.milestone.MilestoneService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

    private final MilestoneService milestoneService;

    private final UserDetailService userDetailService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("projects", milestoneService.findAllprojects());
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = authentication.getName();
        model.addAttribute("user", userDetailService.getuser(username));
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/logout")
    public String showLogoutForm() {
        return "logout";
    }

    @GetMapping("/loginsucces")
    public String loginsucces() {
        return "loginsucces";
    }

}

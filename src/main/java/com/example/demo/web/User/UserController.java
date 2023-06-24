package com.example.demo.web.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User.UserDetailService;
import com.example.demo.domain.User.Userdata;
import com.example.demo.web.milestone.MilestoneForm;

import ch.qos.logback.core.model.Model;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    
    private final UserDetailService userDetailService;

    //ユーザー登録画面
    @GetMapping("/register")
    public String userRegister(){
        return "user/register";
    }

    @PostMapping("/register")
    public String userRegister(@Validated Userdata user){
        userDetailService.createUser(user.getUserName(),user.getPassword());
        return "/milestones";
    }

}

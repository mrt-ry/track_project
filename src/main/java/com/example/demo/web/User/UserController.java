package com.example.demo.web.User;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.repository.query.parser.Part;

import com.example.demo.domain.User.UserDetailService;
import com.example.demo.domain.User.Userdata;
import com.example.demo.web.milestone.MilestoneForm;
import org.springframework.beans.factory.annotation.Value;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDetailService userDetailService;

    // ユーザー登録画面
    @GetMapping("/register")
    public String userRegister() {
        return "user/register";
    }

    @PostMapping("/pro")
    @Transactional
    public String create(@Validated UserForm user) {

        userDetailService.createUser(user.getUserName(), user.getPassword());
        return "user/register";
    }

    @GetMapping("/{userName}")
    public String usersite(Model model, @PathVariable String userName, HttpSession session) {
        model.addAttribute("user", userDetailService.getuser(userName));
        model.addAttribute("project", (String) session.getAttribute("projectId"));
        return "user/pro";
    }

    @GetMapping("/changeIcon")
    public String changeIcon() {
        return "user/changeIcon";
    }

    @PostMapping("/{userName}")
    @Transactional
    public String userChangeIcon(@PathVariable String userName, @RequestParam("file") MultipartFile file,
            HttpServletRequest request, Model model)
            throws ServletException, IOException {
        String filename = file.getOriginalFilename();
        String filePath = "/image/" + filename;
        file.transferTo(new File(
                "/Users/murataryouya/Desktop/track_project 3/track_project/src/main/resources/static" + filePath));
        userDetailService.changeIcon(userName, filePath);
        model.addAttribute("user", userDetailService.getuser(userName));
        return "redirect:/user/" + userName;
    }

    @GetMapping("/2/{userName}")
    public String userprojectsite(@PathVariable String userName, Model model) {
        model.addAttribute("user", userDetailService.getuser(userName));
        return "user/pro2";
    }

    @PostMapping("/2/{userName}")
    @Transactional
    public String user2ChangeIcon(@PathVariable String userName, @RequestParam("file") MultipartFile file,
            HttpServletRequest request, Model model)
            throws ServletException, IOException {
        String filename = file.getOriginalFilename();
        String filePath = "/image/" + filename;
        file.transferTo(new File(
                "/Users/murataryouya/Desktop/track_project 3/track_project/src/main/resources/static" + filePath));
        userDetailService.changeIcon(userName, filePath);
        model.addAttribute("user", userDetailService.getuser(userName));
        return "redirect:/user/2/" + userName;
    }

}

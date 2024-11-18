package com.example.springboot.controller;

import com.example.springboot.domain.User;
import com.example.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signupForm() {
        return "user/signup";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    // 코드 추가 1 :signup 처리
    @PostMapping("/signup")
    public String signup(User user) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/mypage")
    public String myPage(Authentication auth, Model model) {
        User user = userService.getUserById(auth.getName());
        model.addAttribute("user", user);
        return "user/mypage";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/mypage";
    }

    @PostMapping("/delete")
    public String deleteUser(Authentication auth) {
        userService.deleteUser(auth.getName());
        return "redirect:/user/logout";
    }
}



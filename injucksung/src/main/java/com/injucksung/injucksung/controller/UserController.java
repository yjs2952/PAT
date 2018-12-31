package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.domain.User;
import com.injucksung.injucksung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //회원가입하기
    @GetMapping
    public String getSignUpForm() {
        return "/users/signUp";
    }

    @PostMapping
    public String signUp(@ModelAttribute User user) {
        userService.signup(user);
        return "redirect:/session";
    }

    //유저 정보보기
    @GetMapping("/{userId}")
    public String getUserInfo() {
        return null;
    }

    //유저 정보 수정하기
    @PutMapping("/{userId}")
    public String modifyUser() {
        return null;
    }

    //탈퇴하기
    @DeleteMapping("/{userId}")
    public String deleteUser() {
        return null;
    }
}

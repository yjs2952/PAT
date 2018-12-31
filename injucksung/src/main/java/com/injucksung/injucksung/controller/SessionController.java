package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/session")
public class SessionController {
    //로그인하기
    @GetMapping
    public String getLoginForm() {
        return "/session/login";
    }

//    @PostMapping
//    public String login(@ModelAttribute User user) {
//        return null;
//    }

    //로그아웃
    @DeleteMapping
    public String logout() {
        return null;
    }
}

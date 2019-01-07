package com.injucksung.injucksung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class SessionController {
    //로그인하기
    @GetMapping
    public String getLoginForm() {
        return "/session/login";
    }

    //로그아웃
    @DeleteMapping
    public String logout() {
        return null;
    }
}

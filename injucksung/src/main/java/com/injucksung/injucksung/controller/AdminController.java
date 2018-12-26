package com.injucksung.injucksung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminMain() {
        return "admin/index";
    }

    @GetMapping("/admin/book")
    public String book() {
        return "admin/book";
    }

    @GetMapping("/admin/question")
    public String question() {
        return "admin/question";
    }
}

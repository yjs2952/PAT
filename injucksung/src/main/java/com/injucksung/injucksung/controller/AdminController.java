package com.injucksung.injucksung.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class AdminController {
    @GetMapping("/admin/")
    public String main() {
        log.info("<<<<<Start MainController>>>>>");
        return "index";
    }
}

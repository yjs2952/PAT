package com.injucksung.injucksung.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class MainController {
    @GetMapping("/")
    public String main() {
        log.info("<<<<<Start MainController>>>>>");
        return "index";
    }
}

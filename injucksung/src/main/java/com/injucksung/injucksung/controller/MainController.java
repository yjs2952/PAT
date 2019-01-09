package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.security.CustomUserDetails;
import lombok.extern.java.Log;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        log.info("<<<<<Start MainController>>>>>");

        //로그인 정보를 가져와서 캐스팅 가능한 경우만 addAttribute를 진행한다.
        //TODO 최선일까?
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            model.addAttribute("user", principal);
        }

        return "/index";
    }
}

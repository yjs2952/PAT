package com.injucksung.injucksung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    //회원가입하기
    @GetMapping
    public String getRegisterForm() {
        return null;
    }

    @PostMapping
    public String register() {
        return null;
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

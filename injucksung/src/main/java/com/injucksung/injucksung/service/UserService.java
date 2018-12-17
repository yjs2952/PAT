package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.User;

public interface UserService {

    int signup(User user);

    User login(String email, String password);

    int checkDuplicatedEmail(String email);

    int checkDuplicatedNickname(String nickName);

    String findId(String email);

    String findPassword(String email);

    int deleteAccount(String password);

    int modifyUserInfo(User user);
}
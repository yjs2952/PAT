package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.User;
import com.injucksung.injucksung.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int signup(User user) {
        return 0;
    }

    @Override
    public User login(String id, String password) {
        return null;
    }

    @Override
    public int checkDuplicatedEmail(String email) {
        return 0;
    }

    @Override
    public int checkDuplicatedNickname(String nickName) {
        return 0;
    }

    @Override
    public String findId(String email) {
        return null;
    }

    @Override
    public String findPassword(String email) {
        return null;
    }

    @Override
    public int deleteAccount(String password) {
        return 0;
    }

    @Override
    public int modifyUserInfo(User user) {
        return 0;
    }
}

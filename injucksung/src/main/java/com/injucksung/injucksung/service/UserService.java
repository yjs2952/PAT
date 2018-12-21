package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Role;
import com.injucksung.injucksung.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {

    int signup(User user);

    User login(String email, String password);

    int checkDuplicatedEmail(String email);

    int checkDuplicatedNickname(String nickName);

    String findPassword(String email);

    /**
     *
     * @param email     세션으로 부터 받은 이메일
     * @param password  입력받은 본인확인용 비밀번호
     * @return  1: 성공 0: 실패
     */
    void deleteAccount(String email, String password);

    int modifyUserInfo(User user);

    int modifyUserRole(Long id, Long[] roleIds);

    Page<User> getUserList(int start, String searchType, String searchWord);
}
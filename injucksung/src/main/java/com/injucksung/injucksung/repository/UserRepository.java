package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일과 비밀번호로 유저 조회하기
    User findUserByEmailAndPassword(String email, String password);

    // 이메일 중복 여부 검사하기
    boolean existsUserByEmail(String email);

    // 닉네임 중복 여부 검사하기
    boolean existsUserByNickname(String nickname);

    // 이메일로 유저 조회하기
    User findUserByEmail(String email);

    // 이메일로 유저 목록 검색
    Page<User> findAllByEmailContaining(String email, Pageable pageable);

    // 닉네임으로 유저 목록 검색
    Page<User> findAllByNicknameContaining(String nickname, Pageable pageable);

    // 휴대전화번호로 유저 목록 검색
    Page<User> findAllByPhoneContaining(String phoneNo, Pageable pageable);
}

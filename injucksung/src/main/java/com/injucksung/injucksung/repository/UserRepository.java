package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);

    boolean existsUserByEmail(String email);

    boolean existsUserByNickname(String nickname);

    User findUserByEmail(String email);
}

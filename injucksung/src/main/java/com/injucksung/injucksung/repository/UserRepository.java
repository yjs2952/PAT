package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);


}

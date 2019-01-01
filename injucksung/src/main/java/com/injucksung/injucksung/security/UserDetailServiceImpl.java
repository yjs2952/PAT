package com.injucksung.injucksung.security;

import com.injucksung.injucksung.domain.Role;
import com.injucksung.injucksung.domain.User;
import com.injucksung.injucksung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


//@Component
//@RequiredArgsConstructor
//public class UserDetailServiceImpl implements UserDetailsService {
//    private final UserService userService;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userService.getUser(email);
//        if (user == null) {
//            throw new UsernameNotFoundException(email + " is not found");
//        }
////        Collection<Role> roles = user.getRoles();
////        UserDetails userDetails = new org.springframework.security.core.userdetails.User(email,user.getPassword(),roles);
//        return null;
//    }
//}

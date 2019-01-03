package com.injucksung.injucksung.security;

import com.injucksung.injucksung.domain.Role;
import com.injucksung.injucksung.domain.User;
import com.injucksung.injucksung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUser(email);
        if (user == null) {
            throw new UsernameNotFoundException(email + " is not found");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        CustomUserDetails userDetails = new CustomUserDetails(email, user.getPassword(), authorities);
        userDetails.setNickname(user.getNickname());
        userDetails.setId(user.getId());
        return userDetails;
    }
}

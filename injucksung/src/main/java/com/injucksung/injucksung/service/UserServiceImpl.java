package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Role;
import com.injucksung.injucksung.domain.User;
import com.injucksung.injucksung.repository.RoleRepository;
import com.injucksung.injucksung.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private static final int PAGE_SIZE = 10;

    @Override
    @Transactional
    public int signup(User user) {
        // TODO: 18. 12. 17 보라색 밑줄이 매우 거슬리니 나중에 modify와 합칠지 고민해 보세
        User signupUser = userRepository.save(user);
        if (signupUser != null) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.getOne(2L));
            signupUser.setRoles(roles);
            userRepository.flush();
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public User login(String email, String password) {
        // TODO: 18. 12. 17 세션에 저장해야 된다.
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    @Transactional(readOnly = true)
    public int checkDuplicatedEmail(String email) {
        return userRepository.existsUserByEmail(email) ? 1 : 0;
    }

    @Override
    @Transactional(readOnly = true)
    public int checkDuplicatedNickname(String nickName) {
        return userRepository.existsUserByNickname(nickName) ? 1 : 0;
    }

    @Override
    @Transactional(readOnly = true)
    public String findPassword(String email) {
        // TODO: 18. 12. 17 이건 비번 알려주는게 안되니 비번을 변경하게 바꿔줘야 한다.
        return userRepository.findUserByEmail(email).getPassword();
    }

    @Override
    @Transactional
    public void deleteAccount(String email, String password) {
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user != null) userRepository.delete(user);
    }

    @Override
    @Transactional
    public int modifyUserInfo(User user) {
        User modifyUser = userRepository.save(user);
        if (modifyUser != null) {
            userRepository.flush();
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional
    public int modifyUserRole(Long id, Long[] roleIds) {
        User user = userRepository.getOne(id);
        Set<Role> roles = user.getRoles();
        roles.clear();
        if (roles.isEmpty()) {
            for (Long roleId : roleIds) {
                Role role = roleRepository.getOne(roleId);
                roles.add(role);
            }
        }
        user.setRoles(roles);
        if (userRepository.save(user) != null) {
            userRepository.flush();
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> getUserList(int start, String searchType, String searchWord) {
        PageRequest pageRequest = PageRequest.of(start, PAGE_SIZE);
        Page<User> users = null;
        switch (searchType) {
            case "all":
                users = userRepository.findAll(pageRequest);
                break;
            case "email":
                users = userRepository.findAllByEmailContaining(searchWord, pageRequest);
                break;
            case "nickname":
                users = userRepository.findAllByNicknameContaining(searchWord, pageRequest);
                break;
            case "phoneNo":
                users = userRepository.findAllByPhoneContaining(searchWord, pageRequest);
                break;
        }
        return users;
    }
}

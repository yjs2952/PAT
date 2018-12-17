package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.User;
import com.injucksung.injucksung.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public int signup(User user) {
        User signupUser = userRepository.save(user);
        if (signupUser != null) {
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
    public int deleteAccount(String email, String password) {
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user != null) {
            userRepository.delete(user);
            return 1;
        }
        return 0;
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
}

package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 이메일과비밀번호로_로그인() throws Exception {
        User user = userRepository.findUserByEmailAndPassword("admin@naver.com", "1234");
        Assert.assertNotNull(user);
        log.info(user.toString());
    }

    @Test
    public void 이메일중복여부체크() throws Exception {
        boolean isDuplicated = userRepository.existsUserByEmail("admin@naver.com");
        Assert.assertTrue(isDuplicated);
    }

    @Test
    public void 닉네중복여부체크() throws Exception {
        boolean isDuplicated = userRepository.existsUserByNickname("김유저");
        Assert.assertTrue(isDuplicated);
    }

    @Test
    public void 이메일로비밀번호찾기() throws Exception{
        User usr = userRepository.findUserByEmail("admin@naver.com");
        log.info(usr.getPassword());
    }

}


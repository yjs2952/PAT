package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@ComponentScan
@DataJpaTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void 회원가입() throws Exception {
        User user = new User();
        user.setEmail("yjs2952@naver.com");
        user.setPassword("1234");
        user.setNickname("플스사고싶다");
        user.setPhone("01012345678");

        log.info("성공인가 ?  맞으면 1 {}", userService.signup(user));
    }

    @Test
    public void 로그인() throws Exception {
        Assert.assertNotNull(userService.login("user1234@naver.com", "1234"));
    }

    @Test
    public void 이메일중복검사() throws Exception {
        Assert.assertEquals(userService.checkDuplicatedEmail("user1234@naver.com"), 1);
    }

    @Test
    public void 닉네임중복검사() throws Exception {
        Assert.assertEquals(userService.checkDuplicatedNickname("김유저"), 1);
    }

    @Test
    public void 이메일로비밀번호찾기() throws Exception {
        Assert.assertNotNull(userService.findPassword("user1234@naver.com"));
    }

    @Test
    public void 회원탈퇴() throws Exception {
        Assert.assertEquals(userService.deleteAccount("user1234@naver.com", "1234"), 1);
    }

    @Test
    public void 회원정보수정() throws Exception {
        User user = userService.login("user1234@naver.com", "1234");
        user.setNickname("im_your_father!");
        user.setPhone("01033334444");
        Assert.assertEquals(userService.modifyUserInfo(user), 1);
        log.info(userService.login("user1234@naver.com", "1234").toString());
    }
}

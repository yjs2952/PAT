package com.injucksung.injucksung;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    public void passwordEncode() throws Exception{
//        PasswordEncoder encoder2 = new Md4PasswordEncoder();
//        System.out.println(encoder2.encode("1234"));
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
        // {bcrypt}$2a$10$WvTFs5LlBFFsEJvy.exYI.JdezT5.z0hKZDPG7ZnNVwZ9GOYNfczm

        boolean matches = passwordEncoder.matches("1234", "{bcrypt}$2a$10$aVcagsl6.WH81vz39E8Y2eOQZkJcz9qncqqVxFVc54VHcm02/7RPe");
        Assert.assertTrue(matches);
    }

}
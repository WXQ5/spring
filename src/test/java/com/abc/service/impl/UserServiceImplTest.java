package com.abc.service.impl;


import com.abc.common.Res;


import com.abc.service.iservice.IUserService;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @Test
    public void userExist() {
        Res res = userService.userExist("root");
        System.out.println(res);

    }
    @Test
    public void login(){

    }
}
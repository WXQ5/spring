package com.abc.service.impl;

import com.abc.service.iservice.IDeptService;
import com.abc.service.iservice.IEmpService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class IDeptServiceImplTest {
    @Autowired
    IDeptService deptService;
    @Test
    public void findAll() {
        deptService.findAll().getData().stream().forEach(System.out::println);
    }
}
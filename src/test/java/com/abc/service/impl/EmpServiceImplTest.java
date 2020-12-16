package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.Emp;

import com.abc.dao.idao.IEmpDao;

import com.abc.service.iservice.IUserService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmpServiceImplTest {

    @Autowired
    IEmpDao empDao;


    @Test
    public void findByPage() throws Exception {
        List<Emp> emps = null;
        emps = empDao.findByPage(1,10);
        System.out.println("***************"+emps);
    }
}
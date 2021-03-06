package com.abc.dao.idao;

import com.abc.dao.DeptDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class DeptDaoTest {
    @Autowired
    DeptDao deptDao;
    @Test
    public void findAll() {
        deptDao.findAll().stream().forEach(x-> System.out.println(x));
    }
}
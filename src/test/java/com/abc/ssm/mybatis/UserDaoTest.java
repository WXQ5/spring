package com.abc.ssm.mybatis;

import com.abc.ssm.mybatis.dao.UserDao;
import com.abc.ssm.mybatis.dao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void findById() {
       System.out.println("$$$$$$$$"+ userDao.findById(1));
    }
    @Test
    public void findAll(){
        userDao.findAll().stream().forEach(x-> System.out.println(x));
    }
    @Test
    public void findByName(){
        System.out.println(userDao.findByName("赵"));
    }
    @Test
    public void findByPage(){
        userDao.findByPage(2,4).stream().forEach(x-> System.out.println(x));
    }
    @Test
    public void save(){
        User user = new User("张无忌",new BigDecimal(222),new Date());
        userDao.save(user);
    }
    @Test
    public void update(){
            User user = userDao.findById(2);
            user.setUsername("阿雷西欧");
            user.setSal(new BigDecimal("12345"));
            userDao.update(user);
            findAll();
    }
    @Test
    public void delete(){
        userDao.delete(1);
    }
}
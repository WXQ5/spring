package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.service.iservice.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmpServiceImplTest {
    @Autowired
    IEmpService empService;
    @Test
    public void tranferMoney() {
        Res res = empService.tranferMoney(1,2,new BigDecimal(999));
        System.out.println(res);
    }

   /* @Autowired
    EmpDao empDao;


    @Test
    public void findByPage() throws Exception {
        List<Emp> emps = null;
        emps = empDao.findByPage(1,10);
        System.out.println("***************"+emps);
    }*/
}
package com.abc.dao.idao;

import com.abc.controller.vo.DeptEmpVO;
import com.abc.dao.ReportDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ReportDaoTest {
    @Autowired
    ReportDao reportDao;
    @Test
    public void makeReportForDeptEmp() {
        reportDao.makeReportForDeptEmp(new DeptEmpVO(20,new BigDecimal(1000),new BigDecimal(2999))).stream().forEach(x-> System.out.println(x));
    }
}
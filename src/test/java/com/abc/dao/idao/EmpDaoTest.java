package com.abc.dao.idao;

import com.abc.dao.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmpDaoTest {
    @Autowired
    EmpDao empDao;
    @Test
    public void findByPage() {
        empDao.findByPage(2,6).stream().forEach(x-> System.out.println(x));
    }
    @Test
    public void findById() {
        System.out.println(empDao.findById(5));

    }

    @Test
    public void findByName() {
        empDao.findByName("S").stream().forEach(x-> System.out.println(x));
    }

    @Test
    public void delete() {
        Emp emp = empDao.findById(4);
        empDao.delete(emp);
    }

    @Test
    public void save() {
        Emp emp = new Emp("东方不败",new Date(),new BigDecimal(9999));
        empDao.save(emp);
    }

    @Test
    public void update() {
        Emp emp = new Emp();
        emp.setEmpno(5);
        emp.setEname("白衣使者");
        empDao.update(emp);
    }

    @Test
    public void findByDept() {
        empDao.findByDept(20).stream().forEach(System.out::println);

    }

    @Test
    public void delBatch() {
        System.out.println(empDao.delBatch(Arrays.asList(7945,7946,7947)));
    }

    @Test
    public  void findCon() throws ParseException {
        Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-12");
        empDao.findCon("S",hiredate,new BigDecimal(13000)).stream().forEach(x-> System.out.println(x));
        empDao.findCon(null,hiredate,new BigDecimal(13000)).forEach(x-> System.out.println(x));
        empDao.findCon("S",null,new BigDecimal(13000)).forEach(x-> System.out.println(x));
        empDao.findCon("S",null,null).forEach(x-> System.out.println(x));
        empDao.findCon(null,null,null).forEach(x-> System.out.println(x));
    }
    @Test
    public void saveBatch(){
        List<Emp> emps = Arrays.asList(
                new Emp("zhou5",new Date(),new BigDecimal(1234)),
                new Emp("zhou6",new Date(),new BigDecimal(1234)),
                new Emp("zhou7",new Date(),new BigDecimal(1234))
                );
        System.out.println(empDao.saveBatch(emps));
    }

}
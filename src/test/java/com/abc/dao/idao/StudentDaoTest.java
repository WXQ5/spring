package com.abc.dao.idao;

import com.abc.dao.StudentDao;
import com.abc.dao.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;
    /*@Test
    public void one2one() {
        studentDao.one2one().stream().forEach(stu->{
            System.out.println(stu.getSid());
            System.out.println(stu.getSname());
            System.out.println("&&&&&&"+stu.getDid());
            System.out.println("%%%%%%%%%%"+stu.getDept());
            System.out.println("______________________________________________________________");
        });
    }*/

    //学生表 成绩表 课程表 三表联查 多对多案例测试
    @Test
    public void findScoreInfo(){
        List<Student> stus =studentDao.findScoreInfo();
        for (Student student : stus) {
            stus.stream().forEach((stu)->{
                System.out.println("学号："+stu.getSid()+"  姓名： "+stu.getSname());
                stu.getScores().stream().forEach(sc->{
                    System.out.println("课程： "+sc.getCourse().getCname()+"  分数： "+sc.getScore());
                });
                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            });


        }
    }
}
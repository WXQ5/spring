package com.abc.dao.idao;

import com.abc.dao.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> one2one();
    //学生表 成绩表 课程表 三表联查 多对多案例
    List<Student> findScoreInfo();
}

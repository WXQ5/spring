package com.abc.dao;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EmpDao {
    List<Emp> findByPage(@Param("start") int start, @Param("size") int size) ;

    Emp findById(@Param("empno") Integer empno) ;
    List<Emp> findByName(@Param("ename") String ename) ;

    int delete(Emp emp);
    int save(Emp emp);
    int update(Emp emp);


    List<Emp> findByDept(@Param("deptno") int deptno);
    List<Emp> findCon(@Param("ename") String ename, @Param("hiredate") Date hiredate,@Param("sal") BigDecimal sal);

    int delBatch(List<Integer> ids) ;
    int saveBatch(List<Emp> emps);
}

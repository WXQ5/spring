package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import java.math.BigDecimal;
import java.util.List;

public interface IEmpService {
    List<Emp> findByPage(int page, int size);
    List<Emp> findByName(String name);
    Emp findById(Integer empno);

    String delete(Emp emp);
    String save(Emp emp);
    String update(Emp emp);

    Res<List<Emp>> findByDept(int deptno);

    Res delBatch(List<DelVO> delVOList);
    Res saveBatch(List<Emp> empList);
    Res tranferMoney(Integer accountFrom, Integer accountTo, BigDecimal money);
}

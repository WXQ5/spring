package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import com.abc.dao.EmpDao;
import com.abc.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    EmpDao empDao;


    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByPage((page-1)*size,size);

        }catch (Exception e){
            e.printStackTrace();
        }

        return emps;
    }

    @Override
    public List<Emp> findByName(String name) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }
    @Override
    public Emp findById(Integer empno) {
        Emp emp = null;
        try {
            emp = empDao.findById(empno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }
    @Override
    public String delete(Emp emp) {
       int flag = empDao.delete(emp);
       return flag>0?Comm.SUCCESS:Comm.ERROR;
    }

    @Override
    public String save(Emp emp) {
        int flag = empDao.save(emp);
        return flag>0?Comm.SUCCESS:Comm.ERROR;
    }

    @Override
    public String update(Emp emp) {
        int flag = empDao.update(emp);
        return flag>0?Comm.SUCCESS:Comm.ERROR;
    }

    @Override
    public Res<List<Emp>> findByDept(int deptno) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByDept(deptno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (emps != null && emps.size()>0)?Res.sucess(ResEnum.SUCCESS,emps):Res.error();
    }
    @Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW)
    public Res delBatch(List<DelVO> delVOList) {
        //如果传来参数为空 直接返回 保证数据不为空
        if(delVOList == null && delVOList.size() == 0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
           int flag = empDao.delBatch(delVOList.stream().map(x->x.getEmpno()).collect(Collectors.toList()));
           return flag>0? Res.sucess(ResEnum.SUCCESS_DEL_BATCH):Res.error();
    }
@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRES_NEW)
    @Override
    public Res saveBatch(List<Emp> empList) {
        if(empList == null && empList.size() == 0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
       int flag = empDao.saveBatch(empList);
        return flag>0?Res.sucess(ResEnum.ERROR_PARAMS_IN_SAVEBATCH):Res.error();
    }
@Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Res tranferMoney(Integer accountFrom, Integer accountTo, BigDecimal money) {
        Emp empFrom = empDao.findById(accountFrom);
        Emp empTo = empDao.findById(accountTo);
        if (empFrom == null || empTo == null)
            return  Res.error(ResEnum.ERROR_NO_ACCOUNT);
        if(empFrom.getSal().doubleValue() < money.doubleValue())
            return Res.error(ResEnum.ERROR_MONEY_NOT_ENOUGH);
        empFrom.setSal(empFrom.getSal().subtract(money));
        empTo.setSal(empTo.getSal().add(money));
        int flag1 = empDao.update(empFrom);
       // System.out.println(100/0);
        int flag2 = empDao.update(empTo);
        return (flag1+flag2 == 2)? Res.sucess() : Res.error();
    }

}

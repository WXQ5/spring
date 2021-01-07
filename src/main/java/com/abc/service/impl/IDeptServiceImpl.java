package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;

import com.abc.dao.DeptDao;
import com.abc.service.iservice.IDeptService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("deptService")
public class IDeptServiceImpl implements IDeptService {
    @Autowired
    DeptDao deptDao;
    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            PageHelper.startPage(2,2);
            depts = deptDao.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (depts != null && depts.size() >0)?Res.sucess(ResEnum.SUCCESS,depts):Res.error();
    }
}

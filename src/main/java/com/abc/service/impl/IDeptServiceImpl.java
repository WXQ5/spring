package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;

import com.abc.dao.idao.IDeptDao;
import com.abc.service.iservice.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("deptService")
public class IDeptServiceImpl implements IDeptService {
    @Autowired
    IDeptDao iDeptDao;
    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            depts = iDeptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (depts != null && depts.size() >0)?Res.sucess(ResEnum.SUCCESS,depts):Res.error();
    }
}

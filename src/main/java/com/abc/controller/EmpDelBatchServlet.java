package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.SpringIOC;
import com.abc.controller.vo.DelVO;

import com.abc.service.iservice.IEmpService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpDelBatchServlet",urlPatterns = {"/empdelbatch"})
public class EmpDelBatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String empnos = request.getParameter("empnos");
        response.setCharacterEncoding("utf-8");
      //fastjson将字符串empnos变为集合
        List<DelVO> delVOList = JSON.parseObject(empnos,new TypeReference<List<DelVO>>(){});
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        //Res res = empService.delBatch(delVOList);
        PrintWriter out = response.getWriter();
        //ut.println(JSON.toJSONString(res));
        out.close();

    }


}

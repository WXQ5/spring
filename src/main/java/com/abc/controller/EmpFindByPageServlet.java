package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.Emp;

import com.abc.service.iservice.IEmpService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "/EmpFindByPageServlet",urlPatterns = {"/empbypage"})
public class EmpFindByPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //1--取值
        request.setCharacterEncoding("utf-8");
        if(session.getAttribute(Comm.CURRENT_USER) == null){

            session.setAttribute("errMsg","请先登录");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
        int page = 1;
        int size = 10;
        String pageParam = request.getParameter("page");
        String sizeParam = request.getParameter("size");
        //传参的时候需要对完整性进行校验 防止漏洞
        if(pageParam != null && !"".equals(pageParam.trim())){
            page = Integer.parseInt(pageParam);
        }
        if(sizeParam != null && !"".equals(sizeParam.trim())){
            size = Integer.parseInt(sizeParam);
        }
        //2--处理
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        List<Emp> emps = empService.findByPage(page,size);
        response.setCharacterEncoding("utf-8");
        //3--反馈 使用Java模板引擎
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$"+emps);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (emps != null && emps.size() > 0) {
          /*  emps.stream().forEach(x-> {
                        Date date = dateFormat.format(x.getHiredate());
                        x.setHiredate(date);
            });*/

            request.setAttribute("empsFromService",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        } else {

            session.setAttribute("errMsg","分页查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }




    }
}

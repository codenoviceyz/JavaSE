package com.yz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入这个方法");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        //处理请求
        String username = req.getParameter("username");//对应前端中的name属性值
        String password = req.getParameter("password");
        System.out.println("username: "+username+" password: "+password);
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr： "+remoteAddr);

//        ========================
        System.out.println("req.getContextPath(): "+req.getContextPath());//： /response_war
        System.out.println("req.getRequestURL(): "+req.getRequestURL());//：http://localhost:8080/response_war/login
//        重定向时，需要注意路径问题 404-页面未找到
        resp.sendRedirect("/response_war/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

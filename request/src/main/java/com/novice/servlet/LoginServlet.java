package com.novice.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//前端传入后端  乱码问题
        resp.setCharacterEncoding("utf-8"); //后端传入前端    乱码问题

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("hobbies: " + Arrays.toString(hobbies));

        System.out.println("req.getContextPath(): " + req.getContextPath());//： /request
//        重定向(url地址栏会发生变化)：需要注意路径问题 404-页面未找到
//        resp.sendRedirect("/request/success.jsp");
//        请求转发(url地址栏不会发生变化)(/代表当前项目如下：/success.jsp 表示： /request/success.jsp)
        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post 方法执行");
        doGet(req, resp);
    }
}

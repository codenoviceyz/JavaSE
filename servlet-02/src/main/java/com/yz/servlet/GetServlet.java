package com.yz.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GetServlet==="+this.getServletName());
        ServletContext servletContext = this.getServletContext();
        String username = (String) servletContext.getAttribute("username");
        // 设置响应属性
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        resp.getWriter().println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

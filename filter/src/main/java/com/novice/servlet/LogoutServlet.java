package com.novice.servlet;

import com.novice.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if (user_session!=null) {
            System.out.println("LogoutServlet USER_SESSION = " + req.getSession().getAttribute(Constants.USER_SESSION));
            req.getSession().removeAttribute(Constants.USER_SESSION);//移除登陆状态
            resp.sendRedirect("/filter_war/login.jsp");//重新回到登陆页面
        }else{
            resp.sendRedirect("/filter_war/login.jsp");//重新回到登陆页面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

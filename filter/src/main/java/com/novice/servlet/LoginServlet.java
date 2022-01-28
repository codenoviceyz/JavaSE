package com.novice.servlet;

import com.novice.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("LoginServlet.doGet");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        log.info("username:{},password:{}",username,password);
        System.out.printf("username =%s,password = %s", username, password);
        if (Objects.equals(username, "admin")) {
            System.out.println("\n登陆成功");
            //登陆成功后，添加当前用户在线的状态
            req.getSession().setAttribute(Constants.USER_SESSION, req.getSession().getId());
            resp.sendRedirect("/filter_war/sys/success.jsp");
        } else {
            resp.sendRedirect("/filter_war/err.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

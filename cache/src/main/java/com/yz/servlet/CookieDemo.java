package com.yz.servlet;

import cn.hutool.core.date.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置中文乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("CookieDemo");
        PrintWriter out = resp.getWriter();
        // 服务端  从客户端获取Cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            out.write("上一次访问时间为：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastLoginTime")) {
                    String value = cookie.getValue();
                    System.out.println("value: " + value);
                    Date date = DateUtil.parse(value);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("This is first time for you to visit this web site.");
        }
//        服务端给客户端响应Cookie
        String now = DateUtil.formatTime(new Date());
        System.out.println("now: " + now);
        Cookie cookie = new Cookie("lastLoginTime", now);
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

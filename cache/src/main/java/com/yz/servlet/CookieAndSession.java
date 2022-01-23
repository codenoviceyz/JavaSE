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

import static java.lang.System.out;

public class CookieAndSession extends HttpServlet {
    int i = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i++;
        // 设置中文乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        // 服务端  从客户端获取Cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("sessionId")) {
                    String value = cookie.getValue();
                    System.out.println("value: " + value);
                }
            }
        } else {

            out.write("This is first time for you to visit this web site." );
        }

        out.println("i: " + i);
        Cookie cookie = new Cookie("sessionId", "1oenpbm1oksittch481uit1i4lli0cc3");
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);

        // cookie和session的区别
        String cookieStr = getCookie(req);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private static String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        for (Cookie cookieItem : cookies) {
            if (cookieItem.getName().equals("sessionId")) {
                cookie = cookieItem;
            }
        }
        assert cookie != null;
        out.println("req中的SessionId：" + req.getSession().getId());
        out.println("Cookie中的的SessionId：" + cookie.getValue());
        return cookie.getName() + "=" + cookie.getValue();
    }
}

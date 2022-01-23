package com.yz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 存数据
        HttpSession session = req.getSession();
        session.setAttribute("user",new User().builder().name("novice").age(25).build());

        // 获取SessionID
        String id = session.getId();
        //判断session是否为最新
        if(session.isNew()){
            resp.getWriter().write("session 创建成功，id为："+id);
        }else{
            resp.getWriter().write("session 已存在，id为"+id);
        }

//        session 创建时做：
//        Cookie cookie = new Cookie("user", session.getId());
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

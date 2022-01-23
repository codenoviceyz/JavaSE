package com.yz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("invoke self doGet Function");
        System.out.println(req.getParameterMap());
        //响应的类型： html
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");//响应文件编码
        // 构建响应的输出流
         PrintWriter out = resp.getWriter();
         out.println("<html>");
         out.println("<head>");
         out.println("<title>TITLE</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>HelloServlet.doGet()!</h1>");
         out.println("</body>");
         out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

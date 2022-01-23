package com.yz.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ImageServlet");
        resp.setHeader("refresh","3");//刷新时间3s
//        内存中创建图像
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();//笔
        g.setColor(Color.WHITE);
        g.fillRect(0,0,80,20);

        g.setColor(Color.BLUE);
        g.setFont(new Font(null,1,20));
        int x = (int) ((Math.random()*9+1)*100000);
        System.out.println("随机数："+x);
        String str = String.valueOf(x);
        g.drawString(str,0,20);

//        设置该请求以图片的方式打开
        resp.setContentType("image/jpeg");
//        不保存缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

//        把图像流发给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

package com.novice.listener;

import com.novice.utils.Constants;
import org.apache.tomcat.util.bcel.classfile.Constant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
    @Override //创建session得监听
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        System.out.println("OnlineCountListener USER_SESSION= " + se.getSession().getAttribute(Constants.USER_SESSION));
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }
        context.setAttribute("onlineCount", onlineCount);
    }

    @Override //销毁session得监听
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        context.setAttribute("onlineCount", onlineCount);
    }
}

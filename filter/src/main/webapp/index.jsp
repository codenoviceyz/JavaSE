<%@page contentType="text/html; charset=utf-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
当前在线人数：<span><%=this.getServletConfig().getServletContext().getAttribute("onlineCount")%></span>
</body>
</html>

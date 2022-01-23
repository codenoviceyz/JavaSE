<html>
<body>
<h2>Hello World!</h2>
<%--

${pageContext.request.contextPath}或<%=request.getContextPath()%>
如：${pageContext.request.contextPath}/login
    http://localhost:8080/response/login
取出来的就是/login,而"/"代表的含义就是http://localhost:8080/response
--%>

<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"><br>
    密码： <input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>

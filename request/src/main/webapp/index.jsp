<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--

${pageContext.request.contextPath}或<%=request.getContextPath()%>
如：${pageContext.request.contextPath}/login
    http://localhost:8080/response/login
取出来的就是/login,而"/"代表的含义就是http://localhost:8080/response
--%>
登陆测试<br>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码： <input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobbies" value="Singing"/>唱歌
        <input type="checkbox" name="hobbies" value="Watching"/>看剧
        <input type="checkbox" name="hobbies" value="Exercising"/>运动
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>

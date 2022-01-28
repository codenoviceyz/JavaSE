<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/login" method="post">
    用户名:<label><input name="username" type="text"></label>
    密码: <label><input name="password" type="password"></label>
    <label><input name="submit" type="submit"></label>
</form>
</body>
</html>

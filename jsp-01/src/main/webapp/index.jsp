<html>
<body>
<h2>Hello World JSP!</h2>
<%--jsp(语法)--%>
<%= new java.util.Date()%>
<hr>
<%--jsp脚本片段--%>
<%@include file="common/header.jsp"%>
<h2>网页主体1</h2>
<%@include file="common/footer.jsp"%>

<hr>
<jsp:include page="common/header.jsp"/>
<h2>网页主体2</h2>
<jsp:include page="common/footer.jsp"/>

</body>
</html>

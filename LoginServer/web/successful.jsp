<%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/27
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>


</head>
<body>
<h1>
    <%=request.getSession().getAttribute("username")%>欢迎你
</h1>
</body>
</html>

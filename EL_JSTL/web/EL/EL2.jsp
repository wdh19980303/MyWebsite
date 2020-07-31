<%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/28
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中数据</title>
</head>
<body>
<%
    request.setAttribute("name", "alice");
    session.setAttribute("name", "axle");
    request.setAttribute("age", "1");

%>

${requestScope.name}
${sessionScope.name}

</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="color.purple.web.user.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/28
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL标签练习</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("alice", 18, new Date()));
    list.add(new User("kiosk", 15, new Date()));
    list.add(new User("桃酱", 5, new Date()));
    request.setAttribute("list", list);
%>

<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <%--数据行--%>
    <c:forEach items="${requestScope.list}" var="user" varStatus="status">
        <c:if test="${status.count%2 == 0}">
            <tr bgcolor="green">
                <td>${status.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthdayString}</td>
            </tr>
        </c:if>
        <c:if test="${status.count%2 != 0}">
            <tr bgcolor="#dc143c">
                <td>${status.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthdayString}</td>
            </tr>
        </c:if>

    </c:forEach>

</table>

</body>
</html>

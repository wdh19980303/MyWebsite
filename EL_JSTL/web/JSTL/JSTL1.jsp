<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/28
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IF标签</title>
</head>
<body>
<%--
    c:if标签:
        1. 属性:test 接收bool表达式,如果表达式为true,则显示if的标签体内容,如果为false,则不会显示
        2. 没有else情况
--%>
<c:if test="true">
    <h1>are you ok</h1>
</c:if>

<%
    //判断request域中一个集合是否为空,如果不为空则显示遍历集合
    List list = new ArrayList();
    list.add("alice");
    list.add("momo");
    list.add("latisi");
    request.setAttribute("list",list);

%>

 <c:if test="${not empty requestScope.list}">
     假装自己在遍历集合
 </c:if>
</body>
</html>

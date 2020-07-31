<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/28
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
<%--
        foreach:相当于java代码的for语句
        1.  完成重复的操作
        2. 遍历容器
--%>

// 重复操作
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
      <h3>${i}</h3>-----${s.index}------${s.count} <br>
</c:forEach>

// 遍历容器
<br>
<%
    List list = new ArrayList();
    list.add("alice");
    list.add("purple");
    list.add("violet");
    list.add("archer");
    request.setAttribute("list",list);
%>

<c:forEach items="${requestScope.list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str} <br>
</c:forEach>
</body>
</html>

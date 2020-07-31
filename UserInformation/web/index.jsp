<%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/28
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>首页</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>
<div align="center">
  <c:if test="${not empty sessionScope.loginSuccessfulUser}">
    <h1>欢迎管理员用户:${sessionScope.loginSuccessfulUser.name}</h1>
    <a
            href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=1&rows=10" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
  </c:if>
  <c:if test="${empty sessionScope.loginSuccessfulUser}">
    <h1 style="color: red"> 危险访问,服务器已拒绝</h1>
    <A href="login.jsp"><h2>登录</h2></A>
  </c:if>

</div>
</body>
</html>

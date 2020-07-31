<%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/27
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

</head>
<script>
    window.onload = function () {
        document.getElementById("CheckCode").onclick = function () {
            this.src = "ServletCheckCode?time=" + new Date().getTime();
        }
    }
</script>

<style>
    div {
        color: red;
        font-size: 45px;
    }
</style>
<body>
<form action="ServletLogin" method="post">
    <table>
        <tr>
            <td>账户</td>
            <td><input type="text" name="username" id="username" placeholder="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img src="ServletCheckCode" id="CheckCode"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit" value="登录" id="submit"></td>
        </tr>
    </table>
</form>
<div><%=request.getAttribute("CHECK_CODE_ERROR") == null ? " " : request.getAttribute("CHECK_CODE_ERROR")%>
</div>
<div><%=request.getAttribute("LOGIN_ERROR") == null ? " " : request.getAttribute("LOGIN_ERROR") %>
</div>
</body>
</html>

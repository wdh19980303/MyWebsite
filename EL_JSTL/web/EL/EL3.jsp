<%@ page import="color.purple.web.user.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2020/7/28
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象和list集合的值</title>
</head>
<body>
<%
    User user = new User();
    user.setAge(15);
    user.setName("alice");
    user.setBirthday(new Date());
    request.setAttribute("user",user);
%>

<%
    List list = new ArrayList();
    list.add("alice");
    list.add("i love");
    list.add("you");
    list.add("hello");
    list.add(user);
    request.setAttribute("list",list);

    Map  map = new HashMap();
    map.put("A","--A--");
    map.put("D","--D--");
    map.put("B","--B--");
    map.put("C","--C--");
    map.put("user",user);
    request.setAttribute("map",map);
%>





<h3>获取对象中的值</h3>
${requestScope.user.name}<br>
${requestScope.user.age}<br>
${requestScope.user.birthday}<br>
${requestScope.user.birthdayString}<br>
<%--
    * 通过对象的属性来获取
        * setXxxxx 去掉set然后X变小写,
--%>

<h3>获取数组中的值</h3>

${requestScope.list[0]}<br>
${requestScope.list[2]}<br>
${requestScope.list[4].name}<br>


<h3>获取map中的数据</h3>
${requestScope.map.A}<br>
${requestScope.map["B"]}<br>
${requestScope.map.user.name}<br>
${requestScope.map.C}<br>
</body>
</html>


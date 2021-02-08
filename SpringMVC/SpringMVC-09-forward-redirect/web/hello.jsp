<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2021/1/29
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>hello.jsp</h3><br>
    <h3>myName数据：${param.myName}</h3><br>
    <h3>myAge数据：${param.myAge}</h3>
    <h3>取参数数据:<%=request.getParameter("myName")%></h3>
</body>
</html>

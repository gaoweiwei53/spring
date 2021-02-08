<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2021/1/28
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String basePath = request.getScheme()+ "://" +
  request.getServerName() + ":"+ request.getServerPort()+
  request.getContextPath()+"/";
%>
<html>
  <head>
    <title>$Title$</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="static/js/jquery-3.5.1.min.js"></script>
  </head>
  <body>
    <form action="user/some" method="post">
      姓名: <input type="text" name="name"><br/>
      年龄: <input type="text" name="age"><br/>
      <input type="submit" value="提交参数">
    </form>
  <br/>
  <img src="static/images/tim.jpg" alt="我是一个静态资源，不能显示">
  </body>
</html>

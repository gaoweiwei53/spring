<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2021/1/28
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <p>第一个springmvc项目</p>
    <p> <a href="test/some.do">发起some.do的GET请求</a></p>

    <p> <a href="test/other.do">发起other.do的请求</a></p>

    <form action="test/other.do" method="post">
      <input type="submit" value="post请求other.do">
    </form>
  </body>
</html>

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
      <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
      <script type="text/javascript">
          $(function () {
              $("button").click(function (){
                  // alert("button click");
                $.ajax({
                  // url:"returnVoid-ajax.do",
                  // url:"returnStudentJson.do",
                  // url:"returnStudentJsonArray.do",
                  url:"returnStringData.do",
                  data:{
                    name:"zhangshan",
                    age:20
                  },
                  type:"post",
                  //dataType:"json",
                  success:function (resp){
                    // resp从服务端返回的是json格式的字符串 {"name":"zhangshan","age":20}
                    // jsquery会把字符串转为json对象，赋值给resp形参
                    // alert(resp.name + "  " + resp.age);
                    // $.each(resp,function (i,n)){
                    //   alert(n.name + " "+n.age)
                    // }
                    alert(resp+"你好")
                  }
                })
              })
          })
      </script>
  </head>
  <body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString.do" method="post">
      姓名: <input type="text" name="name"><br/>
      年龄: <input type="text" name="age"><br/>
      <input type="submit" value="提交参数">
    </form>
  <br/>
    <p>处理器方法返回String表示视图完整路径</p>
    <form action="returnString2.do" method="post">
      姓名: <input type="text" name="name"><br/>
      年龄: <input type="text" name="age"><br/>
      <input type="submit" value="提交参数">
    </form>
  <br/>
  <br/>
  <button id="btn">发起ajax请求</button>
  </body>
</html>

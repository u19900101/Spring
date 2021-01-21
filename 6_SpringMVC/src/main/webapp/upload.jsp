<%--
  Created by IntelliJ IDEA.
  User: liupannnnnnnnnn
  Date: 2021/1/21
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: brown">${msg}</h1>


<form action="upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username" value="kkkk"/><br/>
    图  像1：<input type="file" name="img" value="pppp"/><br/>
    图  像2：<input type="file" name="img" value="pppp"/><br/>
    图  像3：<input type="file" name="img" value="pppp"/><br/>
    <input type="submit"  value="提交" />
</form>
</body>
</html>

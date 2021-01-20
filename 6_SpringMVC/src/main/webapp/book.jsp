<%--
  Created by IntelliJ IDEA.
  User: liupannnnnnnnnn
  Date: 2021/1/19
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
</head>
<body>

<h1><a href="book/1"/> 查询1号图书</h1>

<%--<form action="book" method="post">
    <input type="submit" value="添加1号图书"/>
</form>--%>
<form action="book/1" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="submit" value="修改1号图书"/>
</form>
<form action="book/1" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <input type="submit" value="删除1号图书"/>
</form>

</body>
</html>

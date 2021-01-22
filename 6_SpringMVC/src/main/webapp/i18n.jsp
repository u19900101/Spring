<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: liupannnnnnnnnn
  Date: 2021/1/20
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>i18n</title>
</head>
<% pageContext.setAttribute("ctp", request.getContextPath());%>
<body>
<a href="${ctp}/i18n2?locale=zh_CN">中文</a>
<a href="${ctp}/i18n2?locale=en_US">英文</a>
<form action="view/h1" method="post">
    <fmt:message key="username"/>:<input type="text" name="username"/><br/>
    <fmt:message key="password"/>:<input type="text" name="password"/><br/>
    <input type="submit" value="<fmt:message key="submit"/>"/><br/>
</form>

</body>
</html>

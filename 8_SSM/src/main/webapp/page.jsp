<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liupannnnnnnnnn
  Date: 2021/1/26
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="5" cellspacing="0" border="1">
    <tr>
        <th>id</th><th>姓名</th><th>邮箱</th>
    </tr>

    <c:forEach items="${info.list}" var="emp">
        <tr>
            <th>${emp.id}</th>
            <th>${emp.lastname}</th>
            <th>${emp.email}</th>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="4">
            <a href="page?pn=1">首页</a>
            <c:if test="${info.pageNum > 1}">
                <a href="page?pn=${info.prePage}">上一页</a>
            </c:if>

            <c:forEach items="${info.navigatepageNums}" var="pn">
                <c:if test="${pn == info.pageNum}">
                        【${pn}】
                </c:if>
                <c:if test="${pn != info.pageNum}">
                    <a href="page?pn=${pn}">${pn}</a>
                </c:if>
            </c:forEach>
            <c:if test="${info.pageNum < info.pages}">
                <a href="page?pn=${info.nextPage}">下一页</a>
            </c:if>

            <a href="page?pn=${info.pages}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <% pageContext.setAttribute("ctp", request.getContextPath());%>
    <script type="text/javascript" src="${ctp}/scripts/jquery-1.9.1.min.js"></script>
    <title>员工列表</title>
</head>
<body>
<%--<% pageContext.setAttribute("ctp", request.getContextPath());
//    System.out.println(request.getContextPath());
%>--%>
<h1>员工列表</h1>
<table border="1" cellpadding="5px" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td><a href="emp/${emp.id}">修改</a></td>
            <td><a href="emp/${emp.id}" class="deleteItem">删除</a></td>
            <!--删除操作可以绑定单击事件，使用ajax发送delete请求-->
           <%-- <td>

            </td>--%>
        </tr>
    </c:forEach>
    <form id = "deleteForm" action="emp/${emp.id}" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>

    <script type="text/javascript">
        $(function () {
            $(".deleteItem").click(function () {
                if(confirm("是否要删除 "+$(this).parent().parent().find("td").eq(2).text()+" ?")){
                    // 1.改变表单的指向
                    $("#deleteForm").attr("action",this.href);
                    // 2.提交表单
                    $("#deleteForm").submit();
                }
                // 不return false的话就会继续执行链接的指向
                return false;
            });
        });
    </script>

    </tbody>
</table>
<a href="toaddpage">添加员工</a>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: liupannnnnnnnnn
  Date: 2021/1/20
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<%--原生表单：<br>
<form action="emp" method="post">
    姓名：<input type="text" name="lastName">${error_info.lastName}<br>
    邮箱：<input type="text" name="email">${error_info.email}<br>
    性别：<br>
    男：<input type="radio" name="gender" value="1"><br>
    女：<input type="radio" name="gender" value="0"><br>
    生日：<input path="birth"/>${error_info.birth}<br>
    部门：<select name="department.id">
    <c:forEach items="${departments}" var="department">
        <option value="${department.id}">${department.departmentName}</option>
    </c:forEach>
</select>
    <input type="submit" value="提交">
</form>--%>

SpringMVC表单：<br>
<%--最大的优点是可以直接回显隐藏模型中的值--%>
<form:form action="emp" method="post" modelAttribute="employee">
    姓名：<form:input path="lastName"></form:input><form:errors path="lastName"></form:errors><br>
    邮箱：<form:input path="email"></form:input><form:errors path="email"></form:errors><br>
    性别：<br>
    男：<form:radiobutton path="gender" value="1"></form:radiobutton>
    女：<form:radiobutton path="gender" value="0"></form:radiobutton><br>
    生日：<form:input path="birth"></form:input><form:errors path="birth"></form:errors><br>
    部门：<form:select path="department.id" items="${departments}"
                    itemLabel="departmentName" itemValue="id">
</form:select>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
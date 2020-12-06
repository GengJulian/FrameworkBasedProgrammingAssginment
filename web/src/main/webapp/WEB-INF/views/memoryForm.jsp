<%--
  Created by IntelliJ IDEA.
  User: gengj
  Date: 12/6/2020
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Emlék létrehozása</title>
</head>
<body>
<form:form method="post" action="addMemory" modelAttribute="memory">
    <form:label path="description">Description</form:label>
    <form:textarea path="description"></form:textarea><br>
    <form:label path="type">Type</form:label>
    <form:select path="type">
        <form:options items="${types}"/>
    </form:select><br>
    <form:input type="hidden" path="ownerId" value="${owner}"/>
    <input type="submit" value="Létrehoz"/>
</form:form>
</body>
</html>

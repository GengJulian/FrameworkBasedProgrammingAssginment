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
    <title>Create a new memory</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container col-8">
    <div style="margin-bottom: 50px">
        <nav class="navbar bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/humans">Home</a>
            </div>
        </nav>
    </div>
    <div class="form col-6 mx-auto">
        <form:form method="post" action="../addMemory" modelAttribute="memory">
            <form:label path="description" class="form-label">Description</form:label>
            <form:textarea path="description" class="form-control"></form:textarea><br>
            <form:label path="type" class="form-label">Type of memory:</form:label>
            <form:select path="type" class="form-control">
                <form:options items="${types}"/>
            </form:select><br>
            <form:input type="hidden" path="ownerId" value="${owner}" class="form-control"/>
            <div class="col-6 mx-auto">
                <input type="submit" value="Create" class="btn btn-success form-control "/>
            </div>
        </form:form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: gengj
  Date: 12/6/2020
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>${human.firstName} ${human.lastName}</title>
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
    <div class="col-10 mx-auto">
        <h2>${human.firstName} ${human.lastName}</h2>
        <h3>ID: ${human.userId}</h3>
        <c:if test="${!empty memories}">
            <table frame="border" rules="all" class="table table-hover table-bordered text-center align-middle">
                <tr scope="col"><th>ID</th>
                    <th scope="col">Created at</th>
                    <th scope="col"></th>
                </tr>
                <c:forEach items="${memories}" var="memory">
                    <tr>
                        <td class="text-center align-middle"><a href="${pageContext.servletContext.contextPath}/memory/${memory.id}">${memory.id}</a></td>
                        <td class="text-center align-middle">${memory.createdAt}</td>
                        <td class="text-center align-middle">
                            <form action="${pageContext.servletContext.contextPath}/deleteMemory/${memory.id}">
                                <input type="submit" value="delete" class="btn btn-danger align-middle" style="margin-top: auto;margin-bottom: auto">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <form action="${pageContext.servletContext.contextPath}/addMemory/${human.userId}" class="col-6 mx-auto">
            <input type="submit" value="add new Memory" class="btn btn-primary form-control">
        </form>
    </div >
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

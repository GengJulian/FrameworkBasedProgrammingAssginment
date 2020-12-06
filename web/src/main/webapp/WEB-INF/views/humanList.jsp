<%--
  Created by IntelliJ IDEA.
  User: gengj
  Date: 12/6/2020
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Memory</title>
</head>
<body>
<c:if test="${!empty humans}">
    <table frame="border" rules="all">
        <tr><th>Azonosito</th><th>Név</th><th>Emlékek száma</th></tr>
        <c:forEach items="${humans}" var="human">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/human/${human.userId}">${human.userId}</a></td>
                <td>${human.firstName} ${human.lastName}</td>
                <td>${human.numberOfMemories}</td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<c:if test="${empty humans}">
    <c:out value="Nincsenek eberek az adatbázisban!"/>
</c:if>

<form action="${pageContext.servletContext.contextPath}/addHuman">
    <input type="submit" value="Human hozzaadasa">
</form>
</body>
</html>

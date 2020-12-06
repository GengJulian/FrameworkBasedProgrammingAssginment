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
</head>
<body>
    <h2>${human.firstName} ${human.lastName}</h2>
    <h3>ID: ${human.userId}</h3>
    <c:if test="${!empty memories}">
    <table frame="border" rules="all">
        <tr><th>Azonosito</th><th>Keletkezett</th></tr>
            <c:forEach items="${memories}" var="memory">
                <tr>
                    <td><a href="${pageContext.servletContext.contextPath}/memory/${memory.id}">${memory.id}</a></td>
                    <td>${memory.createdAt}</td>
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/deleteMemory/${memory.id}">
                            <input type="submit" value="törlés">
                        </form>
                    </td>
                </tr>
            </c:forEach>
    </table>
    </c:if>
    <form action="${pageContext.servletContext.contextPath}/addMemory/${human.userId}">
        <input type="submit" value="Emlék hozzáadása">
    </form>
</body>
</html>

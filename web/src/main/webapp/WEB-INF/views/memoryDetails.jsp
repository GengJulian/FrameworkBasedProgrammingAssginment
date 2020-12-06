<%--
  Created by IntelliJ IDEA.
  User: gengj
  Date: 12/6/2020
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>${memory.id}</title>
</head>
<body>
<h3>${memory.createdAt}</h3>
<p>${memory.description}</p>
<p>${memory.type}</p>
<c:if test="${!empty memory.participants}">
    <ul>
        <c:forEach items="${memory.participants}" var="participant">
            <li><a href="${pageContext.servletContext.contextPath}/human/${participant.userId}">${participant.userId}</a>${participant.firstName} ${participant.lastName}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>

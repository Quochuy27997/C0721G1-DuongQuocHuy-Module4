<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/10/2021
  Time: 4:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test='${condiment != null}'>
    <span>Your sandwich with condiment: </span>
    <c:forEach var="c" items="${condiment}">
        <span>${c}</span>
    </c:forEach>
</c:if>
</body>
</html>

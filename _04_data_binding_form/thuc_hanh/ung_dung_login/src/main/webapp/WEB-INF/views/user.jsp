<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/10/2021
  Time: 4:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome</h1>
<table>
    <tr>
        <td>Account: </td>
        <td>${user.account}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Age: </td>
        <td>${user.age}</td>
    </tr>
</table>
</body>
</html>

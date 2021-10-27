<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/10/2021
  Time: 3:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="sandwich" style="font-size: xx-large">
    <input type="checkbox" name="condiment" id="lettuce" value="Lettuce"> <label for="lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="tomato" value="Tomato"> <label for="tomato">Tomato</label>
    <input type="checkbox" name="condiment" id="mustard" value="Mustard"> <label for="mustard">Mustard</label>
    <input type="checkbox" name="condiment" id="sprouts" value="Sprouts"> <label for="sprouts">Sprouts</label>
    <input type="submit" name="save" value="save">
</form>
</body>
</html>

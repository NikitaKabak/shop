<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 22.04.2018
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>startpage</title>
</head>
<body>
<h2 style="text-align: center">Startpage</h2>
<form action="shop" method="post">login:<input name="login">
    password<input name="password">
    <input type="submit" name="nameButton" value="login"><br>
</form>
<a href="/by/nikita/jsp/registration.jsp">registration</a><br>
<form action="shop" method="post">
    <input type="submit" name="nameButton" value="catalog">
</form>
<a href="/by/nikita/jsp/infoShop.jsp">infoShop</a>
</body>
</html>

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
<form action="/shop/login" method="post">login:<input name="name">
    password<input name="password">
    <input type="submit" name="nameButton" value="login"><br>
</form>
<a href="/by/nikita/jsp/registration.jsp">registration</a><br>

<a href="/shop/catalog">Catalog</a>
<%--<form action="shop" method="post">
    <input type="submit" name="nameButton" value="catalog">
</form>--%>

<a href="/by/nikita/jsp/registration.jsp">registration</a><br>
<br><br><br><br>

<a href="/by/nikita/jsp/Test.jsp">Test</a><br>
</body>
</html>

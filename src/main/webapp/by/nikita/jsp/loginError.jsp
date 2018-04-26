<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 26.04.2018
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginError</title>
</head>
<body>
<h3>Вы ввели не верное имя или пароль</h3>
<form action="shop" method="post">login:<input name="login">
    password<input name="password">
    <input type="submit" name="nameButton" value="login"><br>
</form>
<a href="/by/nikita/jsp/registration.jsp">registration</a><br>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 14.05.2018
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>

<h2>Registration:</h2>
<form  action="/shop/test" method="post"> Name <input name ="name" >  <br>
    Password <input name="password" >  <br>
    Email <input name ="email" >  <br>
    <input type="submit" name="nameButton" value="Reg"><br>
</form>

<form action="/shop/test" method="post">name:<input name="name">
    Qantity:<input name="Qantity">
    <input type="submit" name="nameButton" value="create" >
</form>
<form action="/shop/test" method="post">name:<input name="name">
    Qantity:<input name="Qantity">
    <input type="submit" name="nameButton" value="save" >
</form>
<form action="/shop/test" method="post">
    id:<input name="id">
    name:<input name="name">
    Qantity:<input name="Qantity">
    <input type="submit" name="nameButton" value="update" >
</form>
<form action="/shop/test" method="post">
    id:<input name="id">
    name:<input name="name">
    Qantity:<input name="Qantity">
    <input type="submit" name="nameButton" value="saveOrUpdate" >
</form>
<form action="/shop/test" method="post">
    id:<input name="id">
    <input type="submit" name="nameButton" value="delete" >
</form>
<form action="/shop/test" method="post">
    id:<input name="id">
    <input type="submit" name="nameButton" value="remove" >
</form>
<form action="/shop/test" method="post">
    id:<input name="id">
    <input type="submit" name="nameButton" value="get" >
</form>
<form action="/shop/test" method="post">
    id:<input name="id">
    <input type="submit" name="nameButton" value="read" >
</form>
<form action="/shop/test" method="post">
    <input type="submit" name="nameButton" value="getAll" >
</form>
</body>
</html>

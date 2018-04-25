<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 25.04.2018
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %>

<html>
<head>
    <title>User</title>
</head>

<h2>User Info</h2>

<c:set var="listok" value="${list}"></c:set>

       <c:out value="${listok.get(1)}"/>






</body>
</html>

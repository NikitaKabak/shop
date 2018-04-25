<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 25.04.2018
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UsersInfo</title>
</head>
<body>

<c:forEach var="user" items="${users}">
    <c:out value="${user}"/><br>
</c:forEach>


</body>
</html>

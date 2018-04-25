<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 25.04.2018
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>User</title>
</head>
<body>

<h2>User Info</h2>


<c:out value="+1"> </c:out><br/>

<c:forEach  items="${list}" var="user">
    <c:out value="${user}"> </c:out><br/>
</c:forEach>
<c:out value="${list}"></c:out>

</body>
</html>

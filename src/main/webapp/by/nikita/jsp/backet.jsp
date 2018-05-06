<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 06.05.2018
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Backet</title>
</head>

<h2>MyBacket</h2>

<c:forEach var="byProducts" items="${Backet}">
<c:out value = "${byProducts}"/>

</c:forEach>


</body>
</html>

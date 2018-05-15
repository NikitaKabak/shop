<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 15.05.2018
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>homepageTest</title>
</head>
<c:set var="test" value="${testGet}"></c:set>
<c:if test="${test != null}" >
        ID : <c:out value = "${test.getIdtest()}"/> <br>
        Name: <c:out value = "${test.getName()}"/> <br>
        Qantity: <c:out value = "${test.getQantity()}"/> <br>
</c:if>
<body>
<h3>ok</h3>
</body>
</html>

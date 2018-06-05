<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 04.06.2018
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HomePageUsers</title>
</head>

<c:set var="testUser" value="${TestUser}"></c:set>
<c:if test="${testUser != null}">
    <c:out value="User:"/><br>
    <c:out value="${testUser}"></c:out> // test Ebtity <br>
</c:if>



<c:set var="testOrderList" value="${TestOrderList}"></c:set>
<c:if test="${testOrderList != null}">
    <c:out value="TestOrderList:"/><br>
    <c:forEach var="testOrderList" items="${testOrderList}">
        <c:out value="${testOrderList}"></c:out> <br>
        Order status:
        <c:out value="${testOrderList.getOrgerStatus().getOrderstatus()}"></c:out><br>
       <%-- <c:set var="backetList" value="${testOrderList.getListBacket()}"></c:set>
        <c:forEach var="backetList" items="${backetList}">
            <c:out value="${backetList}"></c:out><br>
            <c:out value="${backetList.getProduct().getNameproduct()}"></c:out><br>
            <c:out value="${backetList.getQantityby()}"></c:out><br>
        </c:forEach>--%>
        <br>
    </c:forEach>
</c:if>

<a href="/shop/catalog">Catalog</a>

<body>

</body>
</html>

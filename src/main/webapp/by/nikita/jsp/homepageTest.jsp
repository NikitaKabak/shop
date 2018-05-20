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
    <c:out value="${test}"></c:out><br>
        <%--ID : <c:out value = "${test.getIdtest()}"/> <br>
        Name: <c:out value = "${test.getName()}"/> <br>
        Qantity: <c:out value = "${test.getQantity()}"/> <br>--%>
</c:if>




<c:set var="listtest" value="${listTest}"></c:set>
<c:if test="${listtest != null}" >
    <c:forEach var="listtest"  items="${listtest}">
        <c:out value="TestEntity:"/><br>
        <c:out value="${listtest}"></c:out> // test Ebtity <br>
        <%-- ID : <c:out value = "${listtest.getIdtest()}"/>
         Name: <c:out value = "${listtest.getName()}"/>
         Qantity: <c:out value = "${listtest.getQantity()}"/> <br>--%>
    </c:forEach>

</c:if>

<c:set var="backetlist" value="${backetList}"></c:set>
<c:if test="${backetlist != null}" >
    <c:out value="BucketList:"/><br>
    <c:forEach var="backetlist"  items="${backetlist}">
        <c:out value="${backetlist}"></c:out> // test Ebtity <br>
        <%-- ID : <c:out value = "${listtest.getIdtest()}"/>
         Name: <c:out value = "${listtest.getName()}"/>
         Qantity: <c:out value = "${listtest.getQantity()}"/> <br>--%>
    </c:forEach>
</c:if>
<c:set var="user" value="${User}"></c:set>
<c:if test="${user != null}" >
    <c:out value="User:"/><br>
    <c:out value="${user}"></c:out> // test Ebtity <br>
   <%-- <c:forEach var="backetlist"  items="${backetlist}">
        <c:out value="${backetlist}"></c:out> // test Ebtity <br>
        &lt;%&ndash; ID : <c:out value = "${listtest.getIdtest()}"/>
         Name: <c:out value = "${listtest.getName()}"/>
         Qantity: <c:out value = "${listtest.getQantity()}"/> <br>&ndash;%&gt;
    </c:forEach>--%>
</c:if>


<c:set var="getorder" value="${getOrder}"></c:set>
<c:if test="${getorder != null}" >
    <c:out value="Order:"/><br>
    <c:out value="${getorder}"></c:out> // test Ebtity <br>
    <%--<c:forEach var="getorder"  items="${getorder}">
        <c:out value="${getorder}"></c:out> // test Ebtity <br>
         ID : <c:out value = "${listtest.getIdtest()}"/>
         Name: <c:out value = "${listtest.getName()}"/>
         Qantity: <c:out value = "${listtest.getQantity()}"/> <br>
    </c:forEach>--%>
</c:if>
<c:set var="getproduct" value="${getProduct}"></c:set>
<c:if test="${getproduct != null}" >
    <c:out value="Product:"/><br>
    <c:out value="${getproduct}"></c:out> // test Ebtity <br>
  <%--  <c:forEach var="getproduct"  items="${getproduct}">
        <c:out value="${getproduct}"></c:out> // test Ebtity <br>
         ID : <c:out value = "${listtest.getIdtest()}"/>
         Name: <c:out value = "${listtest.getName()}"/>
         Qantity: <c:out value = "${listtest.getQantity()}"/> <br>
    </c:forEach>--%>
</c:if>
<body>
<h3>ok</h3>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 30.04.2018
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

    <dl>
        <dt>ID</dt>
        <dd>${product.getIdproduct()}</dd>
        <dt>Name</dt>
        <dd>${product.getNameproduct()}</dd>
        <dt>Status</dt>
        <dd>${product.getIdstatusproduct()}</dd>
        <dt>Price</dt>
        <dd>${product.getPrice()}</dd>
            <%--<dt>Image</dt>
            <dd><img src="productImage?id=${product.id}" /></dd>--%>
    </dl>


</body>
</html>

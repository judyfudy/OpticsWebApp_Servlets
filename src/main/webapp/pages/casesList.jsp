<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 27.01.2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Лінзи</title>
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<c:forEach items="${cases}" var="case">
    <div class="card" style="width: 18rem; display:inline-block;">
        <img class="card-img-top" src="data:image/jpg;base64,${case.image}" alt="Card image cap">
        <div class="card-body">
            <p class="card-text">
            <p> Бренд: ${case.brand}
                Колір: ${case.color}
            <p> Ціна: ${case.price}</p>
        </div>
    </div>
</c:forEach>
</body>
</html>

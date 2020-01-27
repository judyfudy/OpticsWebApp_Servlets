<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 27.01.2020
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Окуляри</title>
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<c:forEach items="${glasses}" var="glass">
    <div class="card" style="width: 18rem; display:inline-block;">
        <img class="card-img-top" src="data:image/jpg;base64,${glass.image}}" alt="Card image cap">
        <div class="card-body">
            <p class="card-text">
            <p>Тип: ${glass.type} Фоорма: ${glass.form} Стать: ${glass.sex}</p>
            <p>Ціна: ${glass.price}</p>
            <p>Матеріал: ${glass.material}</p>
            <p>Бренд: ${glass.brand}</p>
        </div>
    </div>
</c:forEach>
</body>
</html>

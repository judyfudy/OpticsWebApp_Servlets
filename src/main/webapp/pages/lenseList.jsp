<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 27.01.2020
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<c:forEach items="${lenses}" var="lense">
    <div class="card" style="width: 18rem; display:inline-block;">
        <img class="card-img-top" src="data:image/jpg;base64,${lense.image}" alt="Card image cap">
        <div class="card-body">
            <p class="card-text">
            <p>Тип: ${lense.brand}
                Форма: ${lense.appointment}
                Стать: ${lense.diameter}</p> <p>Ціна: ${lense.price}</p>
        </div>
    </div>
</c:forEach>
</body>
</html>

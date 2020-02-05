<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Про нас</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/workerList.css"/>">
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<div class="container" style="margin-top: 10px">
    <div class="content">
        <h1>Про нас</h1>
        <p style="text-align: center; font-family: 'Courier New',serif ">Ми найбільша українська мережа оптик, де ви можете отримати професійну консультацію лікаря-офтальмолога,
            допомогу в підборі і придбанні сучасних і зручних оптичних оправ,
            виготовлення і ремонт окулярів, гарантійне і післягарантійне обслуговування.</p>
    </div>
    <img src="<c:url value="/images/glass_on_yellow.jfif"/>" alt="Notebook" style="width:50%;">
</div>

<h3 style="text-align: center">Наші Лікарі</h3><hr>
<c:forEach items="${workers}" var="worker">
    <div class="card mt-5 mb-5 ml-5" style="display: inline-block">
        <img src="data:image/jpg;base64,${worker.photo}" alt="" style="width:100%">
        <h1>${worker.firstName} ${worker.lastName} ${worker.middleName}</h1>
        <p class="title">Лікар-офтальмолог</p>
        <p>${worker.email}, age: ${worker.age}</p>
        <p>${worker.description}</p>
    </div>
</c:forEach>

</body>
</html>

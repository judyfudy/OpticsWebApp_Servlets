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
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<c:forEach items="${workers}" var="worker">
    <p>${worker.firstName}</p>
    <p>${worker.lastName}</p>
    <p>${worker.middleName}</p>
    <p>${worker.age}</p>
    <p>${worker.experience}</p>
    <img src="data:image/jpg;base64,${worker.photo}" >
</c:forEach>
</body>
</html>

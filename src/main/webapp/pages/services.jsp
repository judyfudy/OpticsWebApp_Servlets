<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 30.01.2020
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Послуги</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/services.css"/>">
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<h3 align="center" style="margin-top: 10px">Послуги</h3>
<hr>

<div class="row" id="rowrow">
    <div class="column">
        <a href="<c:url value="/poslugi_pages/consultation_text.jsp"/>">
            <img src="<c:url value="/images/consulatation.jfif"/>" alt="Sample photo" style="width: 100%;">
        </a>
    </div>
    <div class="column">
        <a href="<c:url value="/poslugi_pages/diagnostic_page.jsp"/>">
            <img src="<c:url value="/images/girl_test.jfif"/>" alt="Sample photo" style="width: 100%;">
        </a>
    </div>
    <div class="column">
        <a href="<c:url value="/poslugi_pages/repair_page.jsp"/>">
            <img src="<c:url value="/images/glasses.jfif"/>" alt="Sample photo" style="width: 100%;">
        </a>
    </div>
</div>
</div>
</div>
</body>
</html>

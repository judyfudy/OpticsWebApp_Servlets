<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Оптика</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>
<body>
<jsp:include page="components/header.jsp"/>
<div class="page-header mt-5">
    <!--Зробити або вставити лого компанія, якщо ні тоді залишити красиве гасло -->
    <h3><i>Ми піклуємось про вас!</i></h3>
</div>

<!--Вставити якусь красиву фотку пов'язану з окулярами, додати клікбейт-текст
 Н-д: Скористайтесь нашими послугами, якими саме "Дізнатися більше, ссилка на послуги"
 Або слідкуйте за нами в соц мережах, або перегляньте наш товар -->
<div class="jumbotron">
    <h1 class="display-4">Hello, world!</h1>
    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
        featured content or information.</p>
    <hr class="my-4">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
    </p>
</div>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Fluid jumbotron</h1>
        <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
    </div>
</div>
</body>
</html>

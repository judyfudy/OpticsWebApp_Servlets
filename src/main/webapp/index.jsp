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
    <link type="text/css" rel="stylesheets" href="<c:url value="/css/homePage.css"/>">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="components/header.jsp"/>
<div class="page-header mt-5">
    <h3 align="center"><i>Ми піклуємось про вас!</i></h3>
    <hr>
</div>

<div class="w3-content w3-display-container">
    <img class="mySlides" src="<c:url value="/images/summer.jpg"/>" style="width:100%">
    <img class="mySlides" src="<c:url value="/images/monkey.jfif"/>" style="width:100%">
    <img class="mySlides" src="<c:url value="/images/sky.jfif"/>" style="width:100%">

    <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
    <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
</div>


<div class="jumbotron jumbotron-fluid" style="background-color: white; margin: 0">
    <div class="container">
        <hr>
        <h1 class="display-4" style="margin: 0" align="center">Бажання лікуватися – крок до одужання.</h1>
        <hr>
    </div>
</div>
<script>
    var slideIndex = 1;
    showDivs(slideIndex);

    function plusDivs(n) {
        showDivs(slideIndex += n);
    }

    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("mySlides");
        if (n > x.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = x.length
        }
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x[slideIndex - 1].style.display = "block";
    }
</script>
</body>
</html>

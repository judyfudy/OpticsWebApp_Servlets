<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 04.02.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Корзина</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/cards.css"/>">
</head>
<body>
<jsp:include page="/components/header.jsp"/>

<button type="button" class="btn btn-primary" style="display:block; margin-top: 30px; margin-left: 30px" onclick="clearCart()">Очистити корзину</button>
<hr>

<c:forEach items="${productList}" var="product">
    <div class="card mt-5 ml-5" style="display: inline-block">
        <img src="data:image/jpg;base64,${product.photo}" alt="Denim Jeans" width="15%" height="15%">
        <h1>${product.name} ${product.model}</h1>
        <p class="price">${product.price}$</p>
        <p>${product.description}, ${product.brand} </p>
        <p>К-сть: ${product.quantity}</p>
        <p>
            <button onclick="removeFromCart(${product.id})">Remove</button>
        </p>
    </div>
</c:forEach>
<script>
    function removeFromCart(id) {
        $.ajax({
            type: "DELETE",
            async: false,
            url: "http://localhost:8080/cart" + '?productId=' + id,
        }).done(function () {
            alert("ВАШ ТОВАР УСПІШНО ВИДАЛЕНО");
        }).fail(function () {
            alert("ВАШ ТОВАР НЕ ВДАЛОСЯ ВИДАЛИТИ, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function clearCart() {
        $.ajax({
            type: "DELETE",
            async: false,
            url: "http://localhost:8080/emptyCart",
        }).done(function () {
            alert("ВСІ ТОВАРИ УСПІШНО ВИДАЛЕНО");
        }).fail(function () {
            alert("ЩОСЬ ПІШЛО НЕ ТАК, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }
</script>
</body>
</html>

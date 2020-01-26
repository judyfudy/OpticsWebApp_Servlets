<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Реєстрація</title>
    <link href="<c:url value="/css/registration.css"/>" rel="stylesheet" type="text/css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
    </script>
</head>
<body>
<form method="post" action="<c:url value="/pages/login.jsp"/>" onsubmit="return validateCredentials()">
    <div class="container mt-3">
        <h1 class="title">Реєстрація</h1>
        <hr>
        <input type="text" placeholder="Ім'я" name="firstName" id="firstName" required>
        <input type="text" placeholder="Прізвище" name="lastName" id="lastName" required>
        <input type="text" placeholder="Ім'я користувача" name="username" id="username" required>
        <input type="password" placeholder="Пароль" name="password" id="password" required>
        <input type="password" placeholder="Введіть пароль ще раз" name="passwordConfirm" id="passwordConfirm" required>
        <hr>
        <div class="signin">
            <button type="submit" class="registerbtn">Зареєструватись</button>
            <p>
                <br>
                Вже зареєстровані ? <a href="<c:url value="/pages/login.jsp"/>">Увійти</a>.
            </p>
        </div>
    </div>
</form>
<script>
    function validateCredentials() {
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var passwordConfirm = document.getElementById("passwordConfirm").value;

        if(password !== passwordConfirm){
            alert("Passwords don't match");
            return false;
        }

        let success = false;
        $.ajax({
            type: "POST",
            async: false,
            url: "/registration",
            data: {
                firstName: firstName,
                lastName: lastName,
                username: username,
                password: password
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 403) {
                alert("User with this username exists!");
            }
        });

        return success;
    }
</script>
</body>
</html>

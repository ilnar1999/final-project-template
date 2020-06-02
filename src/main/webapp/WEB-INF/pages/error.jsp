<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Пользователи</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/images/logo.png">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/navigation-bar-style.css">
    <link rel="stylesheet" href="/resources/css/error-page-style.css">
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="/resources/js/admin-page-scripts.js"></script>
</head>
<body>

<header>
    <h1>АВТОСАЛОН</h1>
</header>

<section>

    <sec:authorize access="isAuthenticated()">
        <nav class="nav">
            <ul>
                <li><a href="/">Каталог</a></li>
                <sec:authorize access="hasAuthority('Admin')">
                    <li><a href="/admin">Пользователи</a></li>
                </sec:authorize>
                <li><a href="">О нас</a></li>
                <li class="right"><a href="/logout"><img class="nav" src="/resources/images/log_out.png"> Выйти</a></li>
                <li class="right"><p>${authorized_user_name}</p></li>
            </ul>
        </nav>
    </sec:authorize>

    <article>
        <p class="error-message">Ошибка при получении доступа!</p>
    </article>

</section>

<footer>
    <p>Powered by <i>Ilnar Khafizov</i> | 2020 | <i>Izhevsk, Russia</i></p>
</footer>

</body>
</html>
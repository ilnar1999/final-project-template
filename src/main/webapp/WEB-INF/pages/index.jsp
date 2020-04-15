<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="cp1251" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="/resources/images/logo.png">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/navigation-bar-style.css">
    <link rel="stylesheet" href="/resources/css/category-area-style.css">
    <title>Каталог</title>
</head>
<body>

<header>
    <h1>АВТОСАЛОН</h1>
</header>

<section>

    <nav class="nav">
        <ul>
            <li><a href="/index">Каталог</a></li>
            <li><a href="/admin">Пользователи</a></li>
            <li><a href="#">О нас</a></li>
            <li class="right"><a href="/logout"><img class="nav" src="/resources/images/log_out.png"> Выйти</a></li>
        </ul>
    </nav>

    <article>

        <div class="category-area">
            <p>Тестовая категория</p>
        </div>

        <c:forEach items="${categories}" var="category">
            <h3>${category.name}</h3>
            <c:forEach items="categories.cars" var="car">

            </c:forEach>
        </c:forEach>

        <p>Добавить новую категорию</p>

    </article>

</section>

<footer>
    <p>Powered by <i>Ilnar Khafizov</i> | 2020 | <i>Izhevsk, Russia</i></p>
</footer>

</body>
</html>




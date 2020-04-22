<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Пользователи</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/images/logo.png">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/navigation-bar-style.css">
    <link rel="stylesheet" href="/resources/css/admin-page-style.css">
</head>
<body>

<header>
    <h1>АВТОСАЛОН</h1>
</header>

<section>

    <nav class="nav">
        <ul>
            <li><a href="/">Каталог</a></li>
            <li><a href="/admin">Пользователи</a></li>
            <li><a href="">О нас</a></li>
            <li class="right"><a href="/logout"><img class="nav" src="/resources/images/log_out.png"> Выйти</a></li>
            <li class="right"><p>${authorized_user_name}</p></li>
        </ul>
    </nav>

    <article>
        <table>
            <tr>
                <th width="30px">Id</th>
                <th width="200px">Логин</th>
                <th>ФИО</th>
                <th width="140px">Дата рождения</th>
                <th width="90px">Менеджер</th>
                <th width="90px">Админ</th>
                <th width="80px"></th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.fullName}</td>
                    <td>${user.dateOfBirthday}</td>
                    <td><input type="checkbox"></td>
                    <td><input type="checkbox"></td>
                    <td><button>Удалить</button</td>
                </tr>
            </c:forEach>
        </table>
    </article>

</section>

<footer>
    <p>Powered by <i>Ilnar Khafizov</i> | 2020 | <i>Izhevsk, Russia</i></p>
</footer>

</body>
</html>

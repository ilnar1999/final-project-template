<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="cp1251" %>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" contentType="text/css" href="/resources/css/style.css" >
    <link rel="stylesheet" contentType="text/css" href="/resources/css/data-entry-form-style.css" >
</head>
<body>

<header>
    <h1>АВТОСАЛОН</h1>
</header>

<section>
    <article>
        <form class="data-entry-form" action="/registration" method="post">
            <h3>Регистрация</h3>
            <hr>
            <div class="area">
                <label>ФИО:</label><br>
                <input class="text-box" size="18" required><br>
            </div>
            <div class="area">
                <label>Дата рождения:</label><br>
                <input class="text-box" size="18" required type="date"><br>
            </div>
            <div class="area">
                <label>Логин:</label><br>
                <input class="text-box" size="18" required><br>
            </div>
            <div class="area">
                <label>Пароль:</label><br>
                <input class="text-box" type="password" class="text" required><br>
            </div>
            <div class="area">
                <label>Подтвердите пароль:</label><br>
                <input class="text-box" type="password" class="text" required><br>
            </div>
            <div class="area">
                <input type="submit" class="button left-button" value="Зарегистрироваться">
                <a href="/login"><input type="button" class="button" value="Назад"></a>
            </div>
        </form>
    </article>
</section>

<footer>
    <p>Powered by <i>Ilnar Khafizov</i> | 2020 | <i>Izhevsk, Russia</i></p>
</footer>

</body>
</html>

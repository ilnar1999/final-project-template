<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/images/logo.png">
    <link rel="stylesheet" contentType="text/css" href="/resources/css/style.css" >
    <link rel="stylesheet" contentType="text/css" href="/resources/css/data-entry-form-style.css" >
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="/resources/js/registration-scripts.js"></script>
</head>
<body>

<header>
    <h1>АВТОСАЛОН</h1>
</header>

<section>
    <article>

        <form class="data-entry-form" action="/registration/proceed" method="post">

            <h3>Регистрация</h3>
            <hr>

            <div class="area">
                <label>ФИО:</label><br>
                <input name="fullName" class="text-box" size="18" required maxlength="40" pattern="[A-Za-zА-Яа-я]+"
                title="Поле должно содержать русские и/или латинские буквы">
            </div>

            <div class="area">
                <label>Дата рождения:</label><br>
                <input id="date-of-birthday" name="dateOfBirthday" class="text-box" size="18" required type="date" min="1900-01-01" max="">
            </div>

            <div class="area">
                <label>Логин:</label><br>
                <input name="login" class="text-box" size="18" required maxlength="30" minlength=5 pattern="[A-Za-z0-9]+"
                title="Логин должен содержать латинские буквы и/или цифры. Минимальная длина логина - 5 символов.">
                <div class="error">${error_login_placeholder}</div>
            </div>

            <div class="area">
                <label>Пароль:</label><br>
                <input name="password" class="text-box" type="password" class="text" required minlength=5 pattern="[A-Za-z0-9]+"
                title="Пароль должен содержать латинские буквы и/или цифры. Минимальная длина пароля - 5 символов.">
                <div class="error">${error_password_placeholder}</div>
            </div>

            <div class="area">
                <label>Подтвердите пароль:</label><br>
                <input name="passwordConfirm" class="text-box" type="password" class="text" required
                title="Подтвердите пароль">
                <div class="error">${error_passwordConfirm_placeholder}</div>
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

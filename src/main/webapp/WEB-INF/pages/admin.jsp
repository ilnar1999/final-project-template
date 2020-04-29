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
    <link rel="stylesheet" href="/resources/css/form-style.css">
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="/resources/js/admin-page-scripts.js"></script>
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

        <form id="search-form" action="/admin">
            <input name="substring_of_login" type="search" placeholder="Логин пользователя">
            <input type="submit" value="Поиск">
        </form>

        <table>
            <tr>
                <th width="50px">Id</th>
                <th width="200px">Логин</th>
                <th width="230px">ФИО</th>
                <th width="140px">Дата рождения</th>
                <th width="90px">Менеджер</th>
                <th width="90px">Админ</th>
                <th width="80px"></th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr id="user-row-${user.id}">
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.fullName}</td>
                    <td>${user.dateOfBirthday}</td>
                    <td><input id="checkbox-Manager-${user.id}" class="role-checkbox" type="checkbox" value="${user.manager}" onchange="setUserRole('Manager', '${user.login}', '${user.id}', this.checked)"></td>
                    <td><input id="checkbox-Admin-${user.id}" class="role-checkbox" type="checkbox" value="${user.admin}" onchange="setUserRole('Admin', '${user.login}', '${user.id}', this.checked)"></td>
                    <td><button id="delete-button-${user.id}" onclick="showDeleteUserForm('${user.id}', '${user.login}')">Удалить</button></td>
                </tr>
            </c:forEach>
        </table>



        <div id="dark-background">

            <form id="delete-user-form" action="/admin/delete-user" method="post">

                <a class="close" onclick="hideAllPopUps()">&times;</a>

                <h3>Удалить пользователя</h3>

                <p id="delete-user-confirm-question"></p>

                <div class="input-area">
                    <input type="hidden" id="delete-user-form-user-id" name="user-id">
                    <input type="submit" value="Да" class="button">
                    <input type="button" value="Нет" class="button" onclick="hideAllPopUps()">
                </div>

            </form>



            <form id="change-user-role-form" action="/admin/set-role-to-user" method="post">

                <a class="close" onclick="changeCheckboxValue()">&times;</a>

                <h3>Изменить права</h3>

                <p id="change-user-role-confirm-question">Хотите изменить роль?</p>

                <div class="input-area">
                    <input type="hidden" id="change-user-role-form-user-id" name="user-id">
                    <input type="hidden" id="change-user-role-form-action" name="action">
                    <input type="hidden" id="change-user-role-form-role" name="role">
                    <input type="submit" value="Да" class="button">
                    <input type="button" value="Нет" class="button" onclick="changeCheckboxValue()">
                </div>

            </form>

        </div>

        <script>
            markCurrentUser(${current_user.id});
        </script>

    </article>

</section>

<footer>
    <p>Powered by <i>Ilnar Khafizov</i> | 2020 | <i>Izhevsk, Russia</i></p>
</footer>

</body>
</html>

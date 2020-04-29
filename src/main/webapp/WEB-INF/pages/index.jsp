<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Каталог</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/images/logo.png">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/navigation-bar-style.css">
    <link rel="stylesheet" href="/resources/css/category-area-style.css">
    <link rel="stylesheet" href="/resources/css/form-style.css">
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script src="/resources/js/index-scripts.js"></script>
</head>
<body>

<header>
    <h1>АВТОСАЛОН</h1>
</header>

<section>

<!-- панель навигации -->
    <nav class="nav">
        <ul>
            <li><a href="/">Каталог</a></li>
            <sec:authorize access="hasAuthority('Admin')">
                <li><a href="/admin">Пользователи</a></li>
            </sec:authorize>
            <li><a onclick="">О нас</a></li>
            <li class="right"><a href="/logout"><img class="nav" src="/resources/images/log_out.png"> Выйти</a></li>
            <li class="right"><p>${authorized_user_name}</p></li>
        </ul>
    </nav>

    <article>

    <sec:authorize access="hasAuthority('Manager')">
        <button id="edit-button" onclick="enableEditMod()">Редактировать</button>
    </sec:authorize>

<!-- генерация категорий из БД -->
        <c:forEach items="${categories}" var="category">
            <div class="category-area">


                <sec:authorize access="hasAuthority('Manager')">
                    <a class="delete-category edit-element" onclick="showDeleteCategoryForm('${category.id}', '${category.name}')">&times;</a>
                </sec:authorize>
                <h3>${category.name}</h3>
                <hr>

                <div class="cars-area">

<!-- генерация автомобилей из БД -->
                    <c:forEach items="${category.cars}" var="car">
<!-- ссылка на форму с информацией об автомобиле -->
                        <a class="car-area" onclick="showCarInformationForm('${car.id}', '${car.image}', '${car.brand}','${car.model}','${car.price}')">
                            <img class="car-img" src="${car.image}">
                        </a>
                    </c:forEach>

<!-- ссылка на форму добавления нового автомобиля -->
                    <sec:authorize access="hasAuthority('Manager')">
                        <a class="add car-area" onclick="showCreateCarForm('${category.id}')" on>
                            <img class="car-img edit-element" src="/resources/images/add-car.png" alt="Добавить автомобиль"/>
                        </a>
                    </sec:authorize>

                </div>

            </div>
        </c:forEach>

<!-- ссылка на форму добавления новой категории -->
        <sec:authorize access="hasAuthority('Manager')">
            <a class="add edit-element" onclick="showCreateCategoryForm()">
                <img class="category-img" src="/resources/images/add-category.png" alt="Добавить категорию"/>
            </a>
        </sec:authorize>

    </article>

<!-- темный фон и формы -->
    <div id="dark-background">

<!-- форма добавления категории -->
        <form id="create-category" action="/edit/create-category" class="form" method="post">

            <a class="close" onclick="hideAllPopUps()">&times;</a>

            <h3>Добавить категорию</h3>

            <div class="input-area">
                <label>Название категории:</label><br>
                <input type="text" name="category-name" class="text" required><br>
                <div id="error-category-name" class="error">${error_category_name}</div>
                <input type="submit" value="Добавить" class="button">
            </div>

        </form>

<!-- форма удаления категории -->
        <form id="delete-category" action="/edit/delete-category" method="post">

            <a class="close" onclick="hideAllPopUps()">&times;</a>

            <h3>Удалить категорию</h3>

            <p id="confirm-category-remove"></p>

            <div class="input-area">
                <input type="hidden" id="category-id" name="category-id">
                <input type="submit" value="Да" class="button">
                <input type="button" value="Нет" class="button" onclick="hideAllPopUps()">
            </div>

        </form>

<!-- форма добавления автомобиля -->
        <form id="create-car" action="/edit/create-car" method="post">

            <a class="close" onclick="hideAllPopUps()">&times;</a>

            <h3>Добавить автомобиль</h3>

            <div class="input-area">

                <input type="hidden" id="create-car-category-id" name="categoryId">

                <table>
                    <tr>
                        <td rowspan="3" width="300px">
                            <img id="changing-car-image" src="/resources/images/sedan.png">
                            <select id="selected-car-image" form="create-car" name="image" onchange="selectImage(this.options[this.selectedIndex].value)">
                                <option value="/resources/images/sedan.png">Седан</option>
                                <option value="/resources/images/sport_car.png">Спорт кар</option>
                                <option value="/resources/images/suv.png">Внедорожник</option>
                            </select>
                        </td>
                        <td width="190px">Производитель: </td>
                        <td width="310px"><input class="text-box" name="brand" required></td>
                    </tr>

                    <tr>
                        <td>Модель:</td>
                        <td><input class="text-box" name="model" required></td>
                    </tr>

                    <tr>
                        <td>Стоимость: </td>
                        <td><input type="number" class="text-box" name="price" min="0" required> $</td>
                    </tr>
                </table>

                <div class="button-area">
                    <input type="submit" value="Добавить" class="button">
                    <input type="reset" value="Сбросить" class="button">
                </div>

                <div id="error-car-exists" class="error">${error_car_exists}</div>
            </div>

        </form>

<!-- форма удаления автомобиля -->
        <form id="delete-car" action="/edit/delete-car" method="post">

            <a class="close" onclick="hideAllPopUps()">&times;</a>

            <h3>Удалить автомобиль</h3>

            <p>Вы действительно хотите удалить этот автомобиль?</p>

            <div class="input-area">
                <input type="hidden" id="delete-car-car-id" name="car-id">
                <input type="submit" value="Да" class="button">
                <input type="button" value="Нет" class="button" onclick="hideAllPopUps()">
            </div>

        </form>

<!-- форма с информацией об автомобиле -->
        <form id="car-information" action="/edit/car-information" method="post">

            <a class="close" onclick="hideAllPopUps()">&times;</a>

            <h3>Описание</h3>

            <div class="input-area">

                <table>
                    <tr>
                        <td rowspan="3" width="410px"><img id="car-information-image" src=""></td>
                        <td id="car-brand"></td>
                    </tr>

                    <tr>
                        <td id="car-model"></td>
                    </tr>

                    <tr>
                        <td id="car-price"></td>
                    </tr>
                </table>

                <div class="button-area">
                    <input type="hidden" name="car-id" id="show-car-information-car-id">
                    <input type="button" value="Заказать" class="button">
                    <input type="button" value="Тест-Драйв" class="button">
                    <sec:authorize access="hasAuthority('Manager')">
                        <input type="button" value="Удалить" class="button edit-element" id="delete-car-button">
                    </sec:authorize>
                </div>
            </div>

        </form>

    </div>

</section>

<footer>
    <p>Powered by <i>Ilnar Khafizov</i> | 2020 | <i>Izhevsk, Russia</i></p>
</footer>

</body>
</html>

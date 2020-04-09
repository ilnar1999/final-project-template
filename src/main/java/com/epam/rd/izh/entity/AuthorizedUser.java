package com.epam.rd.izh.entity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Сущность пользователя, содержит данные(credentials), необходимые для авторизации в Spring Web приложении; Может
 * быть использована как часть бизнес логики приложеняи, например сотрудник больницы, где role определяет его
 * полномочия.
 * <p>
 * Рекомендуется добавить поле id в сущнсть пользователя. Поле id может генерироваться базой данных, также можно
 * добавить в код приложения сервис, генерирующий UUID: 'private UUID id = randomUUID();' и проверяющий его на
 * наличие совпадений с уже существующими.
 */

@Data
public class AuthorizedUser {

    private String fullName;
    private LocalDate dayOfBirthday;
    private String login;
    private String password;
    private Set<String> roles = new HashSet<>(Collections.singleton("User"));


    /**
     * Определяет GrantedAuthority пользователя. Может быть колелкцией, например Set<Strings> если логика приложения
     * подразумевает множество ролей и их комбинацию в пределах одного пользователя.
     * Хорошим решением будет хранить роль в таблице БД, также допускается использовать ENUM класс в пакете utils.
     * Если роль для бизнес-логики не важна, можно задать для всех объектов 'private String role = "User"'.
     */



    /**
     * Ниже представлена простая реализация паттерна builder;
     * Паттерн builder рекомендуется использовать в DTO или часто создаваемых Entity объектах для лаконичности кода;
     * Реализация паттерна builder может быть легко добавлена при помощи библиотеки Lombok.
     */

    public AuthorizedUser fullName(String fullName) {
        this.setFullName(fullName);
        return this;
    }

    public AuthorizedUser dayOfBirthday(LocalDate dayOfBirthday) {
        this.setDayOfBirthday(dayOfBirthday);
        return this;
    }

    public AuthorizedUser login(String login) {
        this.setLogin(login);
        return this;
    }

    public AuthorizedUser password(String password) {
        this.setPassword(password);
        return this;
    }

    public AuthorizedUser role(String role) {
        this.roles.add(role);
        return this;
    }

}

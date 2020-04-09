package com.epam.rd.izh.dto;

import com.epam.rd.izh.entity.AuthorizedUser;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
public class RegisteredUser {

    private String fullName;
    private LocalDate dateOfBirthday;
    private String login;
    private String password;
    private Set<String> roles = new HashSet<>(Collections.singleton("User"));

    public RegisteredUser fullName(String fullName) {
        this.setFullName(fullName);
        return this;
    }

    public RegisteredUser dataOfBirthday(LocalDate dateOfBirthday) {
        this.setDateOfBirthday(dateOfBirthday);
        return this;
    }

    public RegisteredUser login(String login) {
        this.setLogin(login);
        return this;
    }

    public RegisteredUser password(String password) {
        this.setPassword(password);
        return this;
    }

    public RegisteredUser role(String role) {
        this.roles.add(role);
        return this;
    }
}

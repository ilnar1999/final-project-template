package com.epam.rd.izh.entity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
public class AuthorizedUser {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirthday;
    private String login;
    private String password;
    private Set<Role> roles;

    public AuthorizedUser id(Long id) {
        this.setId(id);
        return this;
    }

    public AuthorizedUser fullName(String fullName) {
        this.setFullName(fullName);
        return this;
    }

    public AuthorizedUser dateOfBirthday(LocalDate dateOfBirthday) {
        this.setDateOfBirthday(dateOfBirthday);
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

    public AuthorizedUser roles(Collection<Role> roles) {
        this.roles = new HashSet<>(roles);
        return this;
    }
}

package com.epam.rd.izh.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "t_users")
public class AuthorizedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String fullName;
    private LocalDate dateOfBirthday;
    @Column(unique = true, length = 30)
    private String login;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

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

    public AuthorizedUser roles(Role... roles) {
        Collections.addAll(this.roles, roles);
        return this;
    }
}

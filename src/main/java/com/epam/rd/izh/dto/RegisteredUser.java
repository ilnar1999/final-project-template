package com.epam.rd.izh.dto;
import lombok.Data;

@Data
public class RegisteredUser {

    private String fullName;
    private String dateOfBirthday;
    private String login;
    private String password;
    private String passwordConfirm;
}

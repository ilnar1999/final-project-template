package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.RegisteredUser;
import com.epam.rd.izh.entity.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AuthorizedUserServiceMapper {

    @Autowired
    PasswordEncoder encoder;

    public AuthorizedUser mapRegisteredUserToAuthorizedUser(RegisteredUser registeredUser) {

        return new AuthorizedUser()
                .fullName(registeredUser.getFullName())
                .dateOfBirthday(registeredUser.getDateOfBirthday())
                .login(registeredUser.getLogin())
                .password(encoder.encode(registeredUser.getPassword()))
                .roles(new HashSet<>());
    }
}

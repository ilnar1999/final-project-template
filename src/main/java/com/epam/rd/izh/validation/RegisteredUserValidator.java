package com.epam.rd.izh.validation;

import com.epam.rd.izh.dto.RegisteredUser;
import com.epam.rd.izh.service.AuthorizedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Component
public class RegisteredUserValidator {

    @Autowired
    AuthorizedUserService userService;

    public void validate(RegisteredUser registeredUser, BindingResult bindingResult) {

        if (userService.getUserByLogin(registeredUser.getLogin()) != null) {
            bindingResult.addError(new ObjectError("error_login_placeholder", "Пользователь с таким логином уже существует"));
        }
        if (!registeredUser.getPassword().equals(registeredUser.getPasswordConfirm())) {
            bindingResult.addError(new ObjectError("error_passwordConfirm_placeholder", "Пароли не совпадают"));
        }
    }
}

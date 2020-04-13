package com.epam.rd.izh.validation;

import com.epam.rd.izh.dto.RegisteredUser;
import com.epam.rd.izh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Component
public class RegisteredUserValidator {

    @Autowired
    UserService userService;

    public void validate(RegisteredUser registeredUser, BindingResult bindingResult) {

        if (userService.findUserByLogin(registeredUser.getLogin()) != null) {
            bindingResult.addError(new ObjectError("error_login_placeholder", "Пользователь с таким логином уже существует"));
        }
        if (!registeredUser.getPassword().equals(registeredUser.getPasswordConfirm())) {
            bindingResult.addError(new ObjectError("error_passwordConfirm_placeholder", "Пароли не совпадают"));
        }
        if (registeredUser.getLogin().length() < 5) {
            bindingResult.addError(new ObjectError("error_login_placeholder", "Длина логина должна быть не меньше 5 символов"));
        }
        if (registeredUser.getPassword().length() < 5) {
            bindingResult.addError(new ObjectError("error_password_placeholder", "Длина пароля должна быть не меньше 5 символов"));
        }
    }
}

package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean saveUser(AuthorizedUser user) { // TODO
        return false;
    }

    public AuthorizedUser getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}

package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean saveUser(AuthorizedUser user) {
        if (user != null && !existsUser(user)) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public AuthorizedUser findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean deleteUserByLogin(String login) {
        return userRepository.deleteByLogin(login);
    }

    private boolean existsUser(AuthorizedUser user) {
        if (user == null || findUserByLogin(user.getLogin()) == null) {
            return false;
        }
        return findUserByLogin(user.getLogin()).equals(user);
    }
}

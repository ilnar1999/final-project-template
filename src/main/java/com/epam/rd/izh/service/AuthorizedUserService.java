package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.AuthorizedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizedUserService {

    @Autowired
    AuthorizedUserRepository userRepository;

    public boolean saveUser(AuthorizedUser user) {
        if (userRepository.getUserByLogin(user.getLogin()) == null) {
            return userRepository.saveUser(user);
        }
        return false;
    }

    public AuthorizedUser getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<AuthorizedUser> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }
}

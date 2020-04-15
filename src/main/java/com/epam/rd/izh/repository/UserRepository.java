package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.AuthorizedUser;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public boolean saveUser(AuthorizedUser user) { // TODO
        return false;
    }

    public AuthorizedUser getUserByLogin(String login) { // TODO
        return null;
    }
}

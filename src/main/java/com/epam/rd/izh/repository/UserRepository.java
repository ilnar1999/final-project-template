package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.AuthorizedUser;

import com.epam.rd.izh.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AuthorizedUser, Long> {

    AuthorizedUser findByLogin(String login);

    boolean deleteByLogin(String login);

}

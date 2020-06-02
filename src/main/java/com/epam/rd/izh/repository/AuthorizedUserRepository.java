package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.AuthorizedUser;

import com.epam.rd.izh.entity.Role;
import com.epam.rd.izh.mapper.AuthorizedUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class AuthorizedUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AuthorizedUserMapper userMapper;

    public boolean saveUser(AuthorizedUser user) {
        int updatedRows = 0;
        updatedRows += jdbcTemplate.update(
                "INSERT INTO t_users(full_name, date_of_birthday, login, password) VALUES (?, ?, ?, ?)",
                user.getFullName(),
                LocalDate.parse(user.getDateOfBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                user.getLogin(),
                user.getPassword()
        );
        user.id(getUserByLogin(user.getLogin()).getId());
        for (Role role : user.getRoles()) {
            saveUserRoles(user, role);
        }
        return updatedRows > 0;
    }

    public AuthorizedUser getUserByLogin(String login) {
        List<AuthorizedUser> users = jdbcTemplate.query("SELECT * FROM t_users WHERE login = ? LIMIT 1", userMapper, login);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public List<AuthorizedUser> getAllUsersBySubstringOfLogin(String substringOfLogin) {
        String query = "SELECT * FROM t_users WHERE login LIKE '%" + substringOfLogin + "%'";
        return jdbcTemplate.query(query, userMapper);
    }

    public boolean saveUserRoles(AuthorizedUser user, Role role) {
        return jdbcTemplate.update(
                "INSERT INTO t_users_roles(user_id, role_id) VALUES (?, ?)",
                user.getId(),
                role.getId()
        ) > 0;
    }

    public boolean deleteUserById(Long id) {
        return jdbcTemplate.update("DELETE FROM t_users WHERE id = ?", id) > 0;
    }

    public boolean addRoleToUserByUserIdAndRoleId(Long userId, Long roleId) {
        return jdbcTemplate.update(
                "INSERT INTO t_users_roles(user_id, role_id) VALUES (?, ?)",
                userId,
                roleId
        ) > 0;
    }

    public boolean deleteUserRoleByUserIdAndRoleId(Long userId, Long roleId) {
        return jdbcTemplate.update(
                "DELETE FROM t_users_roles WHERE user_id = ? AND role_id = ?",
                userId,
                roleId
        ) > 0;
    }
}

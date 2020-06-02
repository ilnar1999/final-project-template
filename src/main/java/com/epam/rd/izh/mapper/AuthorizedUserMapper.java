package com.epam.rd.izh.mapper;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.Role;
import com.epam.rd.izh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class AuthorizedUserMapper implements RowMapper<AuthorizedUser> {

    @Autowired
    RoleService roleService;

    @Override
    public AuthorizedUser mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        List<Role> roles = roleService.getAllRolesByUserId(id);
        return new AuthorizedUser()
                .id(id)
                .fullName(resultSet.getString("full_name"))
                .dateOfBirthday(resultSet.getDate("date_of_birthday").toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .login(resultSet.getString("login"))
                .password(resultSet.getString("password"))
                .roles(roles)
                .isManager(roles.contains(roleService.getRoleByName("Manager")))
                .isAdmin(roles.contains(roleService.getRoleByName("Admin")));
    }
}

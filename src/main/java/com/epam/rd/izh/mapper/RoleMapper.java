package com.epam.rd.izh.mapper;

import com.epam.rd.izh.entity.Role;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Role()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"));
    }
}

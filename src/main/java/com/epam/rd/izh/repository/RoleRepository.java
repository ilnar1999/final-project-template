package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Role;
import com.epam.rd.izh.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository  {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRolesByNames(String... names) {
        return jdbcTemplate.query("SELECT * FROM t_roles WHERE name IN (?)", names, roleMapper);
    }

    public List<Role> getAllRolesByUserId(Long userId) {
        return jdbcTemplate.query(
                "SELECT * FROM t_roles WHERE id IN (SELECT role_id FROM t_users_roles WHERE user_id = ?)",
                roleMapper,
                userId
        );
    }
}

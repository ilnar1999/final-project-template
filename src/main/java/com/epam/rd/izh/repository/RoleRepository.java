package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Role;
import com.epam.rd.izh.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepository  {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    RoleMapper roleMapper;

    public Role getRoleByName(String name) {
        List<Role> roles = jdbcTemplate.query("SELECT * FROM t_roles WHERE name = ? LIMIT 1", roleMapper, name);
        if (roles.isEmpty()) {
             return null;
        }
        return roles.get(0);
    }

    public List<Role> getAllRolesByUserId(Long userId) {
        List<Role> roles = jdbcTemplate.query(
                "SELECT * FROM t_roles WHERE id IN (SELECT role_id FROM t_users_roles WHERE user_id = ?)",
                roleMapper,
                userId
        );
        if (roles.isEmpty()) {
            return new ArrayList<>();
        }
        return roles;
    }
}

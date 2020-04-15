package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RoleRepository  {

    public Set<Role> getAllRolesByNames(String... names) { // TODO
        return null;
    }

    public Set<Role> getAllRolesByUserId(Long id) { // TODO
        return null;
    }
}

package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.Role;
import com.epam.rd.izh.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    public List<Role> getAllRolesByUserId(Long id) {
        return roleRepository.getAllRolesByUserId(id);
    }
}

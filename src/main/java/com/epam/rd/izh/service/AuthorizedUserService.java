package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.AuthorizedUserRepository;
import com.epam.rd.izh.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizedUserService {

    @Autowired
    AuthorizedUserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public boolean saveUser(AuthorizedUser user) {
        if (userRepository.getUserByLogin(user.getLogin()) == null) {
            return userRepository.saveUser(user);
        }
        return false;
    }

    public AuthorizedUser getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<AuthorizedUser> getAllUsersBySubstringOfLogin(String substringOfLogin) {
        return userRepository.getAllUsersBySubstringOfLogin(substringOfLogin);
    }

    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }

    public boolean addRoleToUserByUserIdAndRoleName(Long userId, String roleName) {
        if (!roleRepository.getAllRolesByUserId(userId).contains(roleRepository.getRoleByName(roleName))) {
            return userRepository.addRoleToUserByUserIdAndRoleId(userId, roleRepository.getRoleByName(roleName).getId());
        }
        return false;
    }

    public boolean deleteUserRoleByUserIdAndRoleName(Long userId, String roleName) {
        if (roleRepository.getAllRolesByUserId(userId).contains(roleRepository.getRoleByName(roleName))) {
            return userRepository.deleteUserRoleByUserIdAndRoleId(userId, roleRepository.getRoleByName(roleName).getId());
        }
        return false;
    }

    public List<AuthorizedUser> filterUsersBySubstringOfLogin(List<AuthorizedUser> users, String substringOfLogin) {
        users.removeIf(user -> (!user.getLogin().contains(substringOfLogin)));
        return users;
    }
}

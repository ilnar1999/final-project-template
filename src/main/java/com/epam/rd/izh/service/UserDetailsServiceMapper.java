package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.Role;
import com.epam.rd.izh.repository.AuthorizedUserRepository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceMapper implements UserDetailsService {

    @Autowired
    AuthorizedUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        AuthorizedUser user = userRepository.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(
                user.getLogin(),
                user.getPassword(),
                roles
        );
    }

}

package com.escalade.services;

import com.escalade.entity.Users;
import com.escalade.repositories.RolesRepository;
import com.escalade.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolesRepository rolesRepository;


    public Users registerNewUserAccount(final Users users) {

        users.setName(users.getName());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEmail(users.getEmail());
        users.setRoles(Arrays.asList(rolesRepository.findByName("ROLE_USER")));

        return usersRepository.save(users);
    }
}


package com.escalade.services;

import com.escalade.entity.Users;
import com.escalade.error.UserAlreadyExistException;
import com.escalade.repositories.RolesRepository;
import com.escalade.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolesRepository rolesRepository;


    /**
     * Register a new user on BDD with an Encoder Password and a default Role "User"
     *
     * @param users
     */

    public void registerNewUserAccount(final Users users) {
        if (emailExists(users.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + users.getEmail());
        }
        final String role = "USER_ROLES";
        users.setName(users.getName());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEmail(users.getEmail());
        users.setRoles(Arrays.asList(rolesRepository.findByName(role)));
        usersRepository.save(users);
    }

    /**
     * Edit the user role only
     *
     * @param role
     */
    //  @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void ChangeRoleUser(Users role) {
        role.setRoles(Arrays.asList(rolesRepository.findByName("role")));

        usersRepository.save(role);
    }


    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Optional<Users> findById(final Integer id) {
        return usersRepository.findById(id);
    }

    private boolean emailExists(final String email) {
        return usersRepository.findByEmail(email) != null;
    }


    public void delete(Users user) {
        usersRepository.delete(user);
    }
}




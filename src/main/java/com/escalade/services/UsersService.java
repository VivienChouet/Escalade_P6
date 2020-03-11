package com.escalade.services;

import com.escalade.entity.Users;
import com.escalade.error.UserAlreadyExistException;
import com.escalade.repositories.RolesRepository;
import com.escalade.repositories.UsersRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    /**
     * Register a new user on BDD with an Encoder Password and a default Role "User"
     *
     * @param users
     */

    public void registerNewUserAccount(final Users users) {
        logger.info("registerNewUserAccount");
        if (emailExists(users.getEmail())) {
            logger.warn("There is an account with that email adress: " + users.getEmail());
            throw new UserAlreadyExistException("There is an account with that email adress: " + users.getEmail());

        }
        final String role = "USER_ROLES";
        users.setName(users.getName());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEmail(users.getEmail());
        users.setRoles(Arrays.asList(rolesRepository.findByName(role)));
        usersRepository.save(users);
        logger.debug("registerNewUserAccount");
    }

    /**
     * Edit the user role only
     *
     * @param role
     */
    //  @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void ChangeRoleUser(Users role) {

        role.setRoles(Arrays.asList(rolesRepository.findByName("role")));
        logger.debug("ChangeRoleUser : " + role);
        usersRepository.save(role);

    }

    /**
     * @return
     */
    public String UserLogged() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.debug("UserLogged = " + username);
        return username;
    }


    public List<Users> findAll() {
        logger.debug("findAll List User");
        return usersRepository.findAll();
    }


    public Optional<Users> findById(final Integer id) {
        logger.debug("findById Id  = " + id);
        return usersRepository.findById(id);
    }

    private boolean emailExists(final String email) {
        logger.debug("find email : " + email);
        return usersRepository.findByEmail(email) != null;
    }


    public void delete(Users user) {
        logger.debug("delete : " + user);
        usersRepository.delete(user);
    }

}




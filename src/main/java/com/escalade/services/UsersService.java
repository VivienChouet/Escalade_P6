package com.escalade.services;

import com.escalade.entity.Users;
import com.escalade.error.UserAlreadyExistException;
import com.escalade.repositories.RolesRepository;
import com.escalade.repositories.UsersRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
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
        final String role = "ROLE_USER";
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
     * @param users
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void ChangeRoleUser(Users users, Integer id) {
        Users usersold = this.usersRepository.findById(id).get();
        usersold.setUpdate_at(new Date());
        usersold.setRoles(users.getRoles());
        logger.debug("ChangeRoleUser : " + users);
        usersRepository.save(usersold);

    }

    /**
     * @return adress email
     */
    public String UserLoggedEmail() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.debug("UserLogged = " + username);
        return username;
    }

    /**
     * @return Object Users
     */
    public Users usersLogged() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users users = usersRepository.findByEmail(username);
        return users;
    }

    /**
     * @return User_id Logged
     */
    public Integer userLoggedId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user_id = usersRepository.findByEmail(username);
        logger.debug("UserLoggedId = " + user_id.getId());
        logger.debug("userLogged Name = " + user_id.getName());
        return user_id.getId();
    }

    /**
     * @return Users
     */
    public List<Users> findAll() {
        logger.debug("findAll List User");
        return usersRepository.findAll();
    }

    /**
     * @param id
     * @return Optional Users
     */
    public Optional<Users> findById(final Integer id) {
        logger.debug("findById Id  = " + id);
        return usersRepository.findById(id);
    }

    /**
     * @param email
     * @return null if email exist
     */
    public boolean emailExists(final String email) {
        logger.debug("find email : " + email);
        return usersRepository.findByEmail(email) != null;
    }

    /**
     * @param id Delete Users
     */
    public void delete(Integer id) {
        Users users = usersRepository.findById(id).get();
        usersRepository.delete(users);
    }

    public void rolesActuatorOrAdmin() {

    }

}




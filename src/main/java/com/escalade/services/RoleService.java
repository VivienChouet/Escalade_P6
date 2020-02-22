package com.escalade.services;

import com.escalade.entity.Role;
import com.escalade.repositories.RolesRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    RolesRepository rolesRepository;

    public List<Role> findAll() {
        return rolesRepository.findAll();
    }

    public void RoleChange() {

    }

}

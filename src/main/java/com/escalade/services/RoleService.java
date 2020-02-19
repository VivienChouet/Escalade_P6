package com.escalade.services;

import com.escalade.entity.Role;
import com.escalade.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    @Autowired
    RolesRepository rolesRepository;

    public List<Role> findAll() {
        return rolesRepository.findAll();
    }

    public void RoleChange() {


    }
}

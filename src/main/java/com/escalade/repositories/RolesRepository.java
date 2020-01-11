package com.escalade.repositories;

import com.escalade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}

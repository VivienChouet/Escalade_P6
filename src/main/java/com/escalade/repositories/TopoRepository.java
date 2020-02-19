package com.escalade.repositories;

import com.escalade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoRepository extends JpaRepository<Role, Integer> {
}

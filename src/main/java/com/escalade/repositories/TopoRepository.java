package com.escalade.repositories;

import com.escalade.entity.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoRepository extends JpaRepository<Topo, Integer> {

    Topo findByUsers_Id(Integer users);


}

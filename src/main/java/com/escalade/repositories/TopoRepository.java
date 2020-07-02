package com.escalade.repositories;

import com.escalade.entity.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopoRepository extends JpaRepository<Topo, Integer> {


    List<Topo> findByUsers_Id(Integer users);

    List<Topo> findByNameOrLieux(String name, String lieux);

    List<Topo> findByStatutPublic(Boolean statut);


}

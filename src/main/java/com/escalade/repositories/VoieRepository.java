package com.escalade.repositories;

import com.escalade.entity.Voie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoieRepository extends JpaRepository<Voie, Integer> {

    List<Voie> findBySite_id(Integer id);
}

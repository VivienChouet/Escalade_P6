package com.escalade.repositories;

import com.escalade.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Integer> {

    List<Site> findBytopo_id(Integer id);

    List<Site> findByUsers_Id(Integer id);
}

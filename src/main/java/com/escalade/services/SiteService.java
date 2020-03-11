package com.escalade.services;

import com.escalade.entity.Site;
import com.escalade.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    SiteRepository siteRepository;

    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    public void NewSite(Site site) {
        siteRepository.save(site);
    }

    // Création méthode si l'entity a déja une date de parution si vraie alors maj date de parution avec date actuelle sinon = null
    // Idem
}

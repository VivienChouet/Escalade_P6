package com.escalade.services;

import com.escalade.entity.Site;
import com.escalade.repositories.SiteRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    SiteRepository siteRepository;

    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    public void newSite(Site site) {
        logger.info("New Site = " + site);
        siteRepository.save(site);

    }

    public void updateSite(Site site) {
        logger.info("Update Site = " + site);
        siteRepository.save(site);

    }

    public Site findById(Integer id) {
        logger.info("findById = " + id);
        return siteRepository.findById(id).get();
    }


    // Création méthode si l'entity a déja une date de parution si vraie alors maj date de parution avec date actuelle sinon = null
    // Idem
}

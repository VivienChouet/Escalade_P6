package com.escalade.services;

import com.escalade.entity.Voie;
import com.escalade.repositories.VoieRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoieService {
    @Autowired
    VoieRepository voieRepository;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    public void newVoie(Voie voie) {
        logger.info("New Voie  = " + voie);
        voieRepository.save(voie);
    }

    public Voie findById(Integer id) {
        logger.info("findById voie = " + id);
        return voieRepository.findById(id).get();
    }

    public List<Voie> findAll() {
        logger.info("findAll Voie");
        return voieRepository.findAll();
    }

    public void updateVoie(Voie voie) {
        logger.info("Update Voie = " + voie);
        voieRepository.save(voie);
    }

    public List<Voie> findBySite(Integer id) {
        logger.info("findBySite id = " + id);
        return voieRepository.findBySite_id(id);
    }


}

package com.escalade.services;

import com.escalade.entity.Topo;
import com.escalade.repositories.TopoRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopoService {

    @Autowired
    TopoRepository topoRepository;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    public List<Topo> findAll() {
        logger.info("findAll List Topo");
        return topoRepository.findAll();
    }
}

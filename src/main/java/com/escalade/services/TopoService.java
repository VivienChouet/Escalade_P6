package com.escalade.services;

import com.escalade.entity.Topo;
import com.escalade.repositories.TopoRepository;
import com.escalade.repositories.UsersRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopoService {

    @Autowired
    TopoRepository topoRepository;
    UsersRepository usersRepository;
    UsersService usersService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);


    public List<Topo> findAll() {
        logger.debug("findAll List Topo");
        return topoRepository.findAll();
    }

    public void RegisterNewTopo(final Topo topo) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        topo.setName(topo.getName());
        topo.setLieux((topo.getLieux()));
        topo.setDescription(topo.getDescription());
        logger.debug("Register New Topo : " + topo);


    }
}

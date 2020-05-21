package com.escalade.services;

import com.escalade.entity.Topo;
import com.escalade.entity.Users;
import com.escalade.repositories.TopoRepository;
import com.escalade.repositories.UsersRepository;
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

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);


    public List<Topo> findAll() {
        logger.debug("findAll List Topo");
        return topoRepository.findAll();
    }

    public void RegisterNewTopo(final Topo topo) {
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        logger.info("user = " + users);
        topo.setUsers(users);
        topo.setAvailable(true);
        logger.info("Register New Topo : " + topo);
        topoRepository.save(topo);
    }


    public List<Topo> findByTopo() {
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        return topoRepository.findByUsers_Id(users.getId());
    }

    public void updateTopo(final Topo topo) {
        logger.info("update topo = " + topo);
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        topo.setUsers(users);
        topoRepository.save(topo);
    }

    public void newReservation(Integer id) {
        Topo topo = this.topoRepository.findById(id).get();
        topo.setAvailable(false);
        logger.info("topo = " + topo);
        topoRepository.save(topo);

    }

    public Topo findById(Integer id) {
        logger.info("findById = " + id);
        return topoRepository.findById(id).get();
    }

    public List<Topo> research(String name, String lieux) {
        logger.info("Recherche name = " + name + " lieux = " + lieux);
        return topoRepository.findByNameAndLieux(name, lieux);
    }

    public boolean correspondanceUser(Integer id) {
        Integer users = usersService.userLoggedId();
        Topo topo = topoRepository.findById(id).get();
        Users user = topo.getUsers();
        return user.getId() == users;
    }

}

package com.escalade.services;

import com.escalade.entity.Topo;
import com.escalade.entity.Users;
import com.escalade.repositories.ReservationRepository;
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
    ReservationRepository reservationRepository;

    @Autowired
    UsersService usersService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    /**
     * @return List Topo
     */
    public List<Topo> findAll() {
        logger.debug("findAll List Topo");
        return topoRepository.findAll();
    }

    /**
     * @param topo Save New Topo
     */
    public void RegisterNewTopo(final Topo topo) {
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        logger.info("user = " + users);
        topo.setUsers(users);
        topo.setAvailable(true);
        topo.setOfficialTopo(false);
        logger.info("Register New Topo : " + topo);
        topoRepository.save(topo);
    }

    /**
     * @return List Topo By UserLogged
     */
    public List<Topo> findCreatorOfTopo() {
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        return topoRepository.findByUsers_Id(users.getId());
    }

    /**
     * @param topo Save Update Topo
     */
    public void updateTopo(final Topo topo) {
        Topo updateTopo;
        updateTopo = topoRepository.findById(topo.getId()).get();
        logger.info("update topo = " + topo);
        updateTopo.setLieux(topo.getLieux());
        updateTopo.setDescription(topo.getDescription());
        updateTopo.setName(topo.getName());
        updateTopo.setStatutPublic(topo.isStatutPublic());
        updateTopo.setUpdate_at(topo.getUpdate_at());
        topoRepository.save(updateTopo);
    }

    /**
     * @param id Save New Reservation
     */
    public void newReservation(Integer id) {
        Topo topo = this.topoRepository.findById(id).get();
        topo.setAvailable(false);
        logger.info("topo = " + topo);
        topoRepository.save(topo);

    }

    /**
     * @param id Save Available Topo
     */
    public void setAvailableTopo(Integer id) {
        Topo topo = this.topoRepository.findById(id).get();
        topo.setAvailable(true);
        topoRepository.save(topo);
    }

    /**
     * @param id
     * @return Topo By Id
     */
    public Topo findById(Integer id) {
        logger.info("findById = " + id);
        return topoRepository.findById(id).get();
    }

    /**
     * @param name
     * @param lieux
     * @return List Topo Find By Name Or Lieux
     */
    public List<Topo> research(String name, String lieux) {
        logger.info("Recherche name = " + name + " lieux = " + lieux);
        return topoRepository.findByNameOrLieux(name, lieux);
    }

    /**
     * @param id
     * @return userLogged == creatorTopo
     */
    public boolean correspondanceUser(Integer id) {
        Integer users = usersService.userLoggedId();
        Topo topo = topoRepository.findById(id).get();
        Users user = topo.getUsers();
        return user.getId().equals(users);
    }

    /**
     * @return List Topo Public
     */
    public List<Topo> listTopoPublic() {
        return topoRepository.findByStatutPublic(true);
    }

    /**
     * @param id Save official Topo
     */
    public void setOfficialTopo(Integer id) {
        Topo topo = topoRepository.findById(id).get();
        topo.setOfficialTopo(true);
        topoRepository.save(topo);
    }

    /**
     * @param id Save unofficial Topo
     */
    public void setUnOfficialTopo(Integer id) {
        Topo topo = topoRepository.findById(id).get();
        topo.setOfficialTopo(false);
        topoRepository.save(topo);

    }

    /**
     * @return List Topo By UserLogged
     */
    public List<Topo> listTopoUserLogged() {
        Integer id = usersService.userLoggedId();
        return topoRepository.findByUsers_Id(id);
    }


}

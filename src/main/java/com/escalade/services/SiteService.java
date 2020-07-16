package com.escalade.services;

import com.escalade.entity.Site;
import com.escalade.entity.Users;
import com.escalade.repositories.SiteRepository;
import com.escalade.repositories.TopoRepository;
import com.escalade.repositories.UsersRepository;
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

    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TopoRepository topoRepository;

    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    public void newSite(Site site) {
        logger.info("New Site = " + site);
        logger.info("Update Site = " + site);
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        logger.info("user = " + users);
        site.setUsers(users);
        siteRepository.save(site);

    }

    public void updateSite(Site site) {
        logger.info("Update Site = " + site);
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        logger.info("user = " + users);
        site.setUsers(users);
        siteRepository.save(site);

    }

    public Site findById(Integer id) {
        logger.info("findById = " + id);
        return siteRepository.findById(id).get();
    }

    public List<Site> findByIdTopo(Integer id) {
        logger.info("findByIdTopo = " + id);
        return siteRepository.findBytopo_id(id);
    }

    public List<Site> findByUser() {
        String username = usersService.UserLoggedEmail();
        Users users = usersRepository.findByEmail(username);
        logger.info("Find by user = " + users);

        return siteRepository.findByUsers_Id(users.getId());
    }

    public boolean correspondanceUser(Integer id) {
        Integer users = usersService.userLoggedId();
        Site site = siteRepository.findById(id).get();
        Users user = site.getUsers();
        return user.getId() == users;
    }

    public List<Site> findByUserId() {
        Users users = usersService.usersLogged();
        return siteRepository.findByUsers(users);
    }

    public List<Site> research(String name, String contact) {
        return siteRepository.findByNameOrContact(name, contact);
    }


    // Création méthode si l'entity a déja une date de parution si vraie alors maj date de parution avec date actuelle sinon = null
    // Idem
}

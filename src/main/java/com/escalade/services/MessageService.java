package com.escalade.services;

import com.escalade.entity.Message;
import com.escalade.entity.Users;
import com.escalade.repositories.MessageRepository;
import com.escalade.repositories.SiteRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    SiteRepository siteRepository;


    UsersService usersService;


    public void AjoutCommentaire(Integer id, Message message) {
        Users userslogged = usersService.usersLogged();
        logger.info("user logged = " + userslogged);
        message.setUsers(userslogged);
        message.setSite(siteRepository.findById(id).get());
        messageRepository.save(message);
    }

    public List<Message> findBySiteId(Integer id) {
        return messageRepository.findBySite_id(id);
    }

}

package com.escalade.services;

import com.escalade.entity.Message;
import com.escalade.repositories.MessageRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    MessageRepository messageRepository;

    UsersService usersService;


    public void AjoutCommentaire(Integer id, Message message) {

        messageRepository.save(message);
    }

}

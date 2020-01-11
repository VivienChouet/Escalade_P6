package com.escalade.repositories;

import com.escalade.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ramesh Fadatare
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
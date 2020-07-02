package com.escalade.repositories;

import com.escalade.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ramesh Fadatare
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findBySite_id(Integer id);
}
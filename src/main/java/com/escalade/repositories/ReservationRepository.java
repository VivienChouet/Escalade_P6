package com.escalade.repositories;

import com.escalade.entity.Reservation;
import com.escalade.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation findByTopo_IdAndCloseReservation(Integer id, Boolean close);

    List<Reservation> findByTopo_Id(Integer id);

    List<Reservation> findByCloseReservationAndAcceptedReservationAndTopo_Users(Boolean close, Boolean accepted, Users users);
}

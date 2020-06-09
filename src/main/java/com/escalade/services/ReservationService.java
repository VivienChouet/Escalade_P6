package com.escalade.services;

import com.escalade.entity.Reservation;
import com.escalade.entity.Users;
import com.escalade.repositories.ReservationRepository;
import com.escalade.repositories.TopoRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    UsersService usersService;

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    ReservationRepository reservationRepository;

    Reservation reservation = new Reservation();


    public void newReservation(Integer id) {
        Users userslogged = usersService.usersLogged();
        logger.info("user logged = " + userslogged);
        reservation.setUserResevation(userslogged);
        reservation.setTopo(topoRepository.findById(id).get());
        reservation.setReservationStatus("En attente de validation");
        logger.info("reservation = " + reservation);
        reservationRepository.save(reservation);
    }

    public boolean availableReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        return reservation.getReservationStatus() == "disponible";
    }

    public void acceptationReservation() {

    }

    public void refuseReservation() {

    }

}
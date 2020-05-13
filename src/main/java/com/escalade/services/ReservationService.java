package com.escalade.services;

import com.escalade.entity.Reservation;
import com.escalade.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {


    @Autowired
    UsersService usersService;

    @Autowired
    ReservationRepository reservationRepository;

    Reservation reservation;

    public void newReservation() {
        Integer userslogged = usersService.userLoggedId();
        reservation.setUserResevation(userslogged);
        reservation.setTopo();
        reservation.setReservationStatus("En attente de validation");
        reservationRepository.save(reservation);
    }

    public boolean availableReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        return reservation.getReservationStatus() == "disponible";
    }

}
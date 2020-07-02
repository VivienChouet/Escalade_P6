package com.escalade.services;

import com.escalade.entity.Reservation;
import com.escalade.entity.Topo;
import com.escalade.entity.Users;
import com.escalade.repositories.ReservationRepository;
import com.escalade.repositories.TopoRepository;
import com.escalade.utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    UsersService usersService;

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    TopoService topoService;

    @Autowired
    ReservationRepository reservationRepository;

    Reservation reservation = new Reservation();


    public void newReservation(Integer id) {
        Users userslogged = usersService.usersLogged();
        Reservation reservation = new Reservation();
        logger.info("user logged = " + userslogged);
        reservation.setUsers(userslogged);
        reservation.setTopo(topoRepository.findById(id).get());
        reservation.setReservationStatus("En attente de validation");
        reservation.setAcceptedReservation(false);
        reservation.setCloseReservation(false);
        reservation.setCreated_at(new Date());
        logger.info("reservation = " + reservation);
        reservationRepository.save(reservation);
    }

    public boolean availableReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        return reservation.getReservationStatus() == "disponible";
    }

    public void acceptationReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        reservation.setReservationStatus("Reservation validée");
        reservation.setUpdate_at(new Date());
        reservation.setAcceptedReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation accpeted : " + reservation);

    }

    public void refuseReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        Topo topo = this.reservation.getTopo();
        reservation.setReservationStatus("Reservation refusée");
        reservation.setUpdate_at(new Date());
        reservation.setCloseReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation refused : " + reservation);
    }

    public void endReservation() {

    }

    public Reservation findByTopo_idAndNotClosed(Integer id) {
        return reservationRepository.findByTopo_IdAndCloseReservation(id, false);
    }

    public List<Reservation> listFindByTopo_id(Integer id) {
        return reservationRepository.findByTopo_Id(id);
    }

    public Integer findTopoId(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        Topo topo = reservation.getTopo();
        return topo.getId();
    }

    public List<Reservation> findReservationNeededAction() {
        Users userslogged = usersService.usersLogged();
        return reservationRepository.findByCloseReservationAndAcceptedReservationAndTopo_Users(false, false, userslogged);
    }


}
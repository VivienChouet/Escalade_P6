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
        logger.info("New reservation = " + id);
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
        logger.info("Reservation accpeted : " + id);

    }

    public void refuseReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        reservation.setReservationStatus("Reservation refusée");
        reservation.setUpdate_at(new Date());
        reservation.setCloseReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation refused : " + id);
    }

    public void endReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        reservation.setReservationStatus("Reservation terminée");
        reservation.setUpdate_at(new Date());
        reservation.setCloseReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation terminée" + id);


    }

    public Reservation findByTopo_idAndNotClosed(Integer id) {
        logger.info("find by topo_id and not closed");
        return reservationRepository.findByTopo_IdAndCloseReservation(id, false);
    }

    public List<Reservation> listFindByTopo_id(Integer id) {
        return reservationRepository.findByTopo_Id(id);
    }

    public Integer findTopoId(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        Topo topo = reservation.getTopo();
        logger.info("Find Topo Id = " + topo.getId());
        return topo.getId();
    }

    public List<Reservation> findReservationNeededAction() {
        Users userslogged = usersService.usersLogged();
        logger.info("Find Rerservation who needed action");
        return reservationRepository.findByCloseReservationAndAcceptedReservationAndTopo_Users(false, false, userslogged);
    }


    public List<Reservation> findByUsersAndNotClosed() {
        Users userslogged = usersService.usersLogged();
        logger.info("find List reservation  on user logged");
        return reservationRepository.findByUsersAndCloseReservation(userslogged, false);
    }

    public List<Reservation> findByUsersAndClosed() {
        Users userslogged = usersService.usersLogged();
        logger.info("find List reservation  on user logged");
        return reservationRepository.findByUsersAndCloseReservation(userslogged, true);
    }

    public Reservation findByIdAndNotClosed(Integer id) {
        return reservationRepository.findByIdAndCloseReservation(id, false);
    }

    public List<Reservation> listTopoFindByIdReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        Topo topo = reservation.getTopo();

        return reservationRepository.findByTopo_Id(topo.getId());
    }


}
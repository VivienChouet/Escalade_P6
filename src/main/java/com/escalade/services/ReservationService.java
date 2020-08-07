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

    /**
     * @param id Save Reservation
     */
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

    /**
     * @param id Accepted Reservation
     */
    public void acceptationReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        reservation.setReservationStatus("Reservation validée");
        reservation.setUpdate_at(new Date());
        reservation.setAcceptedReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation accpeted : " + id);

    }

    /**
     * @param id Refuse Reservation
     */
    public void refuseReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        reservation.setReservationStatus("Reservation refusée");
        reservation.setUpdate_at(new Date());
        reservation.setCloseReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation refused : " + id);
    }

    /**
     * @param id Close Reservation
     */
    public void endReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        reservation.setReservationStatus("Reservation terminée");
        reservation.setUpdate_at(new Date());
        reservation.setCloseReservation(true);
        reservationRepository.save(reservation);
        logger.info("Reservation terminée" + id);
    }

    /**
     * @param id
     * @return Topo Find By Id && Not Closed
     */
    public Reservation findByTopo_idAndNotClosed(Integer id) {
        logger.info("find by topo_id and not closed");
        return reservationRepository.findByTopo_IdAndCloseReservation(id, false);
    }

    /**
     * @param id
     * @return List Reservation Find By Topo Id
     */
    public List<Reservation> listFindByTopo_id(Integer id) {
        return reservationRepository.findByTopo_Id(id);
    }

    /**
     * @param id
     * @return Topo find By Reservation Id
     */
    public Integer findTopoId(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        Topo topo = reservation.getTopo();
        logger.info("Find Topo Id = " + topo.getId());
        return topo.getId();
    }

    /**
     * @return List Reservation Find By Close False && Accepted False && UsersLogged
     */
    public List<Reservation> findReservationNeededAction() {
        Users userslogged = usersService.usersLogged();
        logger.info("Find Rerservation who needed action");
        return reservationRepository.findByCloseReservationAndAcceptedReservationAndTopo_Users(false, false, userslogged);
    }

    /**
     * @return List Reservation Find By UsersLogged && Reservation False
     */
    public List<Reservation> findByUsersAndNotClosed() {
        Users userslogged = usersService.usersLogged();
        logger.info("find List reservation  on user logged");
        return reservationRepository.findByUsersAndCloseReservation(userslogged, false);
    }

    /**
     * @return List Reservation Find By UsersLogged && Reservation True
     */
    public List<Reservation> findByUsersAndClosed() {
        Users userslogged = usersService.usersLogged();
        logger.info("find List reservation  on user logged");
        return reservationRepository.findByUsersAndCloseReservation(userslogged, true);
    }

    /**
     * @param id
     * @return Reservation Find By Id && Reservation False
     */
    public Reservation findByIdAndNotClosed(Integer id) {
        return reservationRepository.findByIdAndCloseReservation(id, false);
    }

    /**
     * @param id
     * @return List Reservation Find By Topo Id
     */
    public List<Reservation> listTopoFindByIdReservation(Integer id) {
        Reservation reservation = this.reservationRepository.findById(id).get();
        Topo topo = reservation.getTopo();

        return reservationRepository.findByTopo_Id(topo.getId());
    }


}
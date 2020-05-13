package com.escalade.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_reservation")
    private Integer userResevation;
    @Column(name = "topo")
    private Integer topo;
    @Column(name = "reservation_status")
    private String reservationStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserResevation() {
        return userResevation;
    }

    public void setUserResevation(Integer userResevation) {
        this.userResevation = userResevation;
    }

    public Integer getTopo() {
        return topo;
    }

    public void setTopo(Integer topo) {
        this.topo = topo;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setTopo() {
    }
}

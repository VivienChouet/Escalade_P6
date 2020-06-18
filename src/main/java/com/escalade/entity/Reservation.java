package com.escalade.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Users userResevation;
    @ManyToOne
    private Topo topo;
    @Column(name = "reservation_status")
    private String reservationStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUserResevation() {
        return userResevation;
    }

    public void setUserResevation(Users userResevation) {
        this.userResevation = userResevation;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
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

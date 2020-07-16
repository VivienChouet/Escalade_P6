package com.escalade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Topo topo;
    @Column(name = "reservation_status")
    private String reservationStatus;
    @Column(name = "closeReservation")
    private Boolean closeReservation;
    @Column(name = "acceptedReservation")
    private Boolean acceptedReservation;
    @CreationTimestamp
    private Date update_at = new Date();
    @CreationTimestamp
    private Date created_at = new Date();

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", users=" + users +
                ", topo=" + topo +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", closeReservation=" + closeReservation +
                ", acceptedReservation=" + acceptedReservation +
                ", update_at=" + update_at +
                ", created_at=" + created_at +
                '}';
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getCloseReservation() {
        return closeReservation;
    }

    public void setCloseReservation(Boolean closeReservation) {
        this.closeReservation = closeReservation;
    }

    public Boolean getAcceptedReservation() {
        return acceptedReservation;
    }

    public void setAcceptedReservation(Boolean acceptedReservation) {
        this.acceptedReservation = acceptedReservation;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setTopo() {
    }
}

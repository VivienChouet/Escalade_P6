package com.escalade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String adresse;

    private String contact;

    private String reservation;

    @CreationTimestamp
    @Column(name = "createdat")
    private Date createdAt;
    @Column(name = "updateat")
    @CreationTimestamp
    private Date updateAt;
    @ManyToMany(mappedBy = "site")
    private List<Voie> voie;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "site_topo",
            joinColumns = {@JoinColumn(name = "SITE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "TOPO_ID", referencedColumnName = "ID")})
    private List<Topo> topo;

    public List<Voie> getVoie() {
        return voie;
    }

    public void setVoie(List<Voie> voie) {
        this.voie = voie;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

}

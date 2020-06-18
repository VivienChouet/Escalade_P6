package com.escalade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "topo")
public class Topo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String lieux;
    @Column(nullable = false)
    private String description;
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at = new Date();
    @Column(name = "available")
    private boolean available;
    @Column(name = "statut_public")
    private boolean statutPublic;
    @Column(name = "officialTopo")
    private boolean officialTopo;
    @OneToMany
    private List<Reservation> reservations;
    @Column(name = "update_at")
    @CreationTimestamp
    private Date update_at = new Date();
    @ManyToOne()
    private Users users;
    @OneToMany(mappedBy = "topo")
    private List<Site> site;

    public boolean isOfficialTopo() {
        return officialTopo;
    }

    public void setOfficialTopo(boolean officialTopo) {
        this.officialTopo = officialTopo;
    }

    public boolean isStatutPublic() {
        return statutPublic;
    }

    public void setStatutPublic(boolean statutPublic) {
        this.statutPublic = statutPublic;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String adresse) {
        this.lieux = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String telephone) {
        this.description = telephone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date createdAt) {
        this.created_at = createdAt;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date updateAt) {
        this.update_at = updateAt;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Site> getSite() {
        return site;
    }

    public void setSite(List<Site> site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lieux='" + lieux + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", available=" + available +
                ", statutPublic=" + statutPublic +
                ", reservations=" + reservations +
                ", update_at=" + update_at +
                ", users=" + users +
                ", site=" + site +
                '}';
    }
}




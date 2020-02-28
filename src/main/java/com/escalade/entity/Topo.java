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
    @Column(nullable = false, unique = true)

    private String description;
    @Column(name = "createdat")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updateAt")
    @CreationTimestamp
    private Date updateAt;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "topo_user",
            joinColumns = {@JoinColumn(name = "TOPO_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    private List<Users> users;
    @ManyToMany(mappedBy = "topo")
    private List<Site> site;

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String adresse) {
        this.lieux = adresse;
    }

    public String getDescription() {
        return description;
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

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public void setDescription(String telephone) {
        this.description = telephone;
    }

    public List<Site> getSite() {
        return site;
    }

    public void setSite(List<Site> site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return name;
    }
}



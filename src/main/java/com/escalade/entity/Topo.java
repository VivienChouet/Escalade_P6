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
    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at = new Date();
    @Column(name = "update_at")
    @CreationTimestamp
    private Date update_at = new Date();
    @ManyToOne()
    private Users users;
    @OneToMany(mappedBy = "topo")
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
                ", createdAt=" + created_at +
                ", updateAt=" + update_at +
                ", users=" + users +
                ", site=" + site +
                '}';
    }
}



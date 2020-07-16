package com.escalade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "voie")
public class Voie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int longueur;
    private String difficulte;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "update_at")
    @CreationTimestamp
    private Date update_at;
    @ManyToOne()
    private Site site;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulté) {
        this.difficulte = difficulté;
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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

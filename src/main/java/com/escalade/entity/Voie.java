package com.escalade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voie")
public class Voie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int longeur;

    private String difficulté;

    @CreationTimestamp
    @Column(name = "createdat")
    private Date createdAt;
    @Column(name = "updateat")
    @CreationTimestamp
    private Date updateAt;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "voie_site",
            joinColumns = {@JoinColumn(name = "VOIE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SITE_ID", referencedColumnName = "ID")})
    private List<Site> site;

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

    public int getLongeur() {
        return longeur;
    }

    public void setLongeur(int longeur) {
        this.longeur = longeur;
    }

    public String getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(String difficulté) {
        this.difficulté = difficulté;
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

}

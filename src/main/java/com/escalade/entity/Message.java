package com.escalade.entity;


import javax.persistence.*;

/**
 * @author Ramesh Fadatare
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "content", nullable = false)
    private String content;


    @ManyToOne
    private Site site;


    @ManyToOne
    private Users users;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users id_user) {
        this.users = id_user;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site id_site) {
        this.site = id_site;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
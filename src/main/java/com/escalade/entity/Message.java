package com.escalade.entity;


import javax.persistence.*;

/**
 * @author Ramesh Fadatare
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "id_site")
    @ManyToOne
    private Site id_site;

    @Column(name = "id_user")
    @ManyToOne
    private Users id_user;


    public Users getId_user() {
        return id_user;
    }

    public void setId_user(Users id_user) {
        this.id_user = id_user;
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
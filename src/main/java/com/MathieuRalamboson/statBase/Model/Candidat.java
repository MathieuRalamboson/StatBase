package com.MathieuRalamboson.statBase.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Candidat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true, updatable = false)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private String code;
    private String nom;
    private String prenom;
    private String imageUrl;

    public Candidat() {
    }

    public Candidat(Integer id, String code, String nom, String prenom, String imageUrl) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

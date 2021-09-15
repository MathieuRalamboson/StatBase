package com.MathieuRalamboson.statBase.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Candidat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String nom;
    private String prenom;
    private String imageUrl;

    public Candidat() {
    }

    public Candidat(Integer id, String nom, String prenom, String imageUrl) {
        this.id = id;
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

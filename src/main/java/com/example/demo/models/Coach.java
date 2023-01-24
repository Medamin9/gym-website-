package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Coach {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

    private String prenom;

    private String specialite;

    private String photo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public Coach() {
    }

    
    public Coach(String nom, String prenom, String specialite, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.photo = photo;
    }

    public long getId() {
        return id;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setId(Long id) {
        this.id=id;
    }
}

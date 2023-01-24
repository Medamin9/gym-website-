package com.example.demo.models;

import javax.persistence.*;

import java.util.*;


@Entity
public class Salle {
    

    @Id
    @GeneratedValue()
    private long id;

    private String nom;


    private String telephone;


    @OneToMany(mappedBy = "salle")
    private List<Coach> coaches;

    @OneToMany(mappedBy = "salle")
    private List<Offre> offres;

    @OneToMany(mappedBy = "salle")
    private List<Activite> activites;

    public Salle() { }

    public Salle(String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public List<Offre> getOffres() {
        return offres;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }
}

package fr.railcommandeer.app.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexa on 02/06/2016.
 */
public class Utilisateurs implements Serializable{
    private long id_user;

    private String prenom;

    private String nom;

    private String mdp;

    public String civilite;

    private String adresse;

    private String email;

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public List<Reservations> getListReservation() {
        return ListReservation;
    }

    public void setListReservation(List<Reservations> listReservation) {
        ListReservation = listReservation;
    }


    private java.util.List<Reservations> ListReservation;

    public Utilisateurs(String email, String mdp, String nom, String prenom, String adresse, java.util.List<Reservations> listReservation) {
        this.email = email;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        ListReservation = listReservation;
    }

    public Utilisateurs() {

    }

}

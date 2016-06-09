package fr.railcommandeer.app.entity;


import com.google.gson.Gson;
import fr.railcommandeer.app.ReponseRest.PossibilityReponse;

/**
 * Created by alexa on 02/06/2016.
 */
public class Reservations {


    long id;

    Utilisateurs reservationsuser;

    String civilite;

    String nom;

    String prenom;

    String email;


    String possibilityReponse;

    public PossibilityReponse getPossibilityReponse() {
        Gson gson = new Gson();
        return  gson.fromJson(possibilityReponse, PossibilityReponse.class);
    }


    public void setPossibilityReponse(String possibilityReponse) {
        Gson gson = new Gson();
        gson.fromJson(possibilityReponse, PossibilityReponse.class);
        this.possibilityReponse = possibilityReponse;
    }
    public void setPossibilityReponse(PossibilityReponse possibilityReponse) {
        Gson gson = new Gson();
        this.possibilityReponse =  gson.toJson(possibilityReponse);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Utilisateurs getReservationsuser() {
        return reservationsuser;
    }

    public void setReservationsuser(Utilisateurs reservationsuser) {
        this.reservationsuser = reservationsuser;
    }

}

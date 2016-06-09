package fr.railcommandeer.app.entity;

import java.io.Serializable;

/**
 * Created by alexa on 04/06/2016.
 */
public class Route implements Serializable{


    private int id;

    public Integer distance;

    private Gare Gare_depart;

    private Ligne ligne;

    private  Gare Gare_arrivee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Gare getGare_depart() {
        return Gare_depart;
    }

    public void setGare_depart(Gare gare_depart) {
        Gare_depart = gare_depart;
    }

    public Gare getGare_arrivee() {
        return Gare_arrivee;
    }

    public void setGare_arrivee(Gare gare_arrivee) {
        Gare_arrivee = gare_arrivee;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }
}

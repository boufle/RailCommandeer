package fr.railcommandeer.app.entity;

import android.graphics.Point;


import java.util.List;

/**
 * Created by alexa on 02/06/2016.
 */
public class Gare {

    private long id;

    private String nom_gare;

    private Point gps;

    public String typetrain;

    public Integer code_postal;

    public String ville;

    private transient  java.util.List<Voyages> Voyage_Depart;

    private transient  java.util.List<Voyages> Voyage_arrivee;

    private Escale Escale_gare;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_gare() {
        return nom_gare;
    }

    public void setNom_gare(String nom_gare) {
        this.nom_gare = nom_gare;
    }

    public Point getGps() {
        return gps;
    }

    public void setGps(Point gps) {
        this.gps = gps;
    }

    public java.util.List<Voyages> getVoyage_Depart() {
        return Voyage_Depart;
    }

    public void setVoyage_Depart(List<Voyages> voyage_Depart) {
        Voyage_Depart = voyage_Depart;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(Integer code_postal) {
        this.code_postal = code_postal;
    }

    public List<Voyages> getVoyage_arrivee() {
        return Voyage_arrivee;
    }

    public void setVoyage_arrivee(List<Voyages> voyage_arrivee) {
        Voyage_arrivee = voyage_arrivee;
    }
}


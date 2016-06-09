package fr.railcommandeer.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by alexa on 02/06/2016.
 */

public class Trains implements Serializable{

    private int id;

    private double surplus;

    private Date Date_depart;

    private int nbr_place;

    private Ligne ligne;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSurplus() {
        return surplus;
    }

    public void setSurplus(double surplus) {
        this.surplus = surplus;
    }

    public Date getDate_depart() {
        return Date_depart;
    }

    public void setDate_depart(Date date_depart) {
        Date_depart = date_depart;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }

 }

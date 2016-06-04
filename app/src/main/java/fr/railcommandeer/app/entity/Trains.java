package fr.railcommandeer.app.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by alexa on 02/06/2016.
 */

public class Trains {

    private int id;

    private double surplus;

    private Date heure_depart;

    private int nbr_place;

    private List<Trains> train;

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

    public Date getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(Date heure_depart) {
        this.heure_depart = heure_depart;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public List<Trains> getTrain() {
        return train;
    }

    public void setTrain(List<Trains> train) {
        this.train = train;
    }
}

package fr.railcommandeer.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by alexa on 02/06/2016.
 */

public class Voyages implements Serializable{


    private int id;

    private Date date_depart;
    private Date date_arrivee;

    private List<Reservations> Reservation;


    private Gare Gare_depart;

    private  Gare Gare_arrivee;

    private Escale Escale_voyage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public List<Reservations> getReservation() {
        return Reservation;
    }

    public void setReservation(List<Reservations> reservation) {
        Reservation = reservation;
    }

    public Gare getGare_Depart() {
        return Gare_depart;
    }

    public void setGare_Depart(Gare gare_Depart) {
        Gare_depart = gare_Depart;
    }

    public Gare getGare_arrivee() {
        return Gare_arrivee;
    }

    public void setGare_arrivee(Gare gare_arrivee) {
        Gare_arrivee = gare_arrivee;
    }
}

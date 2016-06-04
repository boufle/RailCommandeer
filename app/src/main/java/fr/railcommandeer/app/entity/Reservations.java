package fr.railcommandeer.app.entity;



/**
 * Created by alexa on 02/06/2016.
 */
public class Reservations {


    private int id;

    private Utilisateurs MyUser;

    private Voyages MyVoyage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateurs getMyUser() {
        return MyUser;
    }

    public void setMyUser(Utilisateurs myUser) {
        MyUser = myUser;
    }

    public Voyages getMyVoyage() {
        return MyVoyage;
    }

    public void setMyVoyage(Voyages myVoyage) {
        MyVoyage = myVoyage;
    }
}

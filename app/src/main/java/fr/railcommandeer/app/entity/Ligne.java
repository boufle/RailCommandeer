package fr.railcommandeer.app.entity;

import okhttp3.Route;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Théo on 07/06/2016.
 */
public class Ligne implements Serializable {

    long id;



    String nomLigne;


    private transient List<Route> routeList;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomLigne() {
        return nomLigne;
    }

    public void setNomLigne(String nomLigne) {
        this.nomLigne = nomLigne;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }
}

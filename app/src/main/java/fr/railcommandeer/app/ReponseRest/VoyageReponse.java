package fr.railcommandeer.app.ReponseRest;

import com.google.gson.Gson;
import okhttp3.Route;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexa on 04/06/2016.
 */
public class VoyageReponse implements Serializable {
    ArrayList<PossibilityReponse> possibilityReponses = new ArrayList<PossibilityReponse>();
     List<Route> routeList = new ArrayList<Route>();

    Success success = new Success(false,"Erreur inconue");

    public VoyageReponse(Success success) {
        this.success = success;
    }

    public VoyageReponse() {

    }

    public ArrayList<PossibilityReponse> getPossibilityReponses() {
        return possibilityReponses;
    }

    public void setPossibilityReponses(ArrayList<PossibilityReponse> possibilityReponses) {
        this.possibilityReponses = possibilityReponses;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }


    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }

    public String toJson(){
        Gson gson = new Gson();
        return  gson.toJson(this);
    }

}

package fr.railcommandeer.app.ReponseRest;


import fr.railcommandeer.app.entity.Deal;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexa on 04/06/2016.
 */
public class DealReponse implements Serializable {
    List<Deal> dealList = null;
    Success success = new Success(false,"Erreur inconue");

    public DealReponse(List<Deal> dealList, Success success) {
        this.dealList = dealList;
        this.success = success;
    }

    public DealReponse() {

    }

    public List<Deal> getGares() {
        return dealList;
    }

    public void setGares(List<Deal> gares) {
        this.dealList = gares;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }



}

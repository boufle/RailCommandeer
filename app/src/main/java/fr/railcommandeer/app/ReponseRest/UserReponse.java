package fr.railcommandeer.app.ReponseRest;


import fr.railcommandeer.app.entity.Utilisateurs;

import java.io.Serializable;

/**
 * Created by alexa on 04/06/2016.
 */
public class UserReponse implements Serializable {
    Utilisateurs user = null;
    Success success = new Success(false,"Erreur inconue");

    public UserReponse(Utilisateurs user, Success success) {
        this.user = user;
        this.success = success;
    }

    public UserReponse() {

    }

    public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }



}

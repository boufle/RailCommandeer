package fr.railcommandeer.app.Utils;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import fr.railcommandeer.app.ReponseRest.GaresReponse;
import fr.railcommandeer.app.entity.Gare;

import java.util.ArrayList;

/**
 * Created by Boufle on 04/06/2016.
 */
public class ClientUnirest {

    public ClientUnirest(){

    }

    public ArrayList<Gare> downloadGare(){


        HttpResponse<GaresReponse> bookResponse = null;
        try {
            bookResponse = Unirest.get("http://pastebin.com/raw/Z5UcFdZy").asObject(GaresReponse.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        GaresReponse bookObject = bookResponse.getBody();


        return new ArrayList<Gare>();
    }
}

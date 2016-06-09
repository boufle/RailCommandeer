package fr.railcommandeer.app.Utils;


import fr.railcommandeer.app.entity.Gare;
import fr.railcommandeer.app.entity.Utilisateurs;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Boufle on 04/06/2016.
 */
public class ClientUnirest {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    String response;
    JSONObject jsonObj;
    private Map<String, String> out = new HashMap<String, String>();


    public ClientUnirest(){

    }

    public ArrayList<Gare> downloadGare(){


        try {
          response =   getHTML("http://pastebin.com/raw/Z5UcFdZy");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
             jsonObj = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(jsonObj.getJSONObject("gares"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        try {
            String test = jsonObj.getJSONObject("gares").getString("nom_gare");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(out.size());


        return new ArrayList<Gare>();
    }

    public boolean isConnectionCheck(String username, String password){

        String test = null;
        Utilisateurs utilisateurs = new Utilisateurs();
        try {
            response = getHTML("http://pastebin.com/raw/DGLYAp6U");
            jsonObj = new JSONObject(response);
            test = jsonObj.getJSONObject("success").getString("success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (test.equals("true")){
            try {
                if (jsonObj.getJSONObject("user").getString("email").equals(username) && jsonObj.getJSONObject("user").getString("mdp").equals(password)){
                    utilisateurs.setNom(jsonObj.getJSONObject("user").getString("nom"));
                    utilisateurs.setPrenom(jsonObj.getJSONObject("user").getString("prenom"));
                    utilisateurs.setAdresse(jsonObj.getJSONObject("user").getString("adresse"));
                    utilisateurs.setCivilite(jsonObj.getJSONObject("user").getString("civilite"));
                    utilisateurs.setEmail(jsonObj.getJSONObject("user").getString("email"));
                    utilisateurs.setId_user(jsonObj.getJSONObject("user").getInt("id_user"));
                    utilisateurs.setMdp(jsonObj.getJSONObject("user").getString("mdp"));

                    ClientLog.utilisateurs = utilisateurs;
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        return false;
    }


    public boolean isInscriptionCheck (String nom, String prenom, String email, String mdp, String adresse){
        Utilisateurs utilisateurs = new Utilisateurs();
        String test = null;
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, "");

        Request request = new Request.Builder()
                .url("http:10.29.18.39:8080/rest/userrest/addUser")
                .post(body)
                .addHeader("nom", nom)
                .addHeader("prenom", prenom)
                .addHeader("email", email)
                .addHeader("mdp", mdp)
                .addHeader("civilite", "Mr")
                .addHeader("adresse", adresse)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "4b0b8c55-6360-0033-668e-043319ea74e3")
                .build();

        try {
            Response response = client.newCall(request).execute();

            jsonObj = new JSONObject(response.body().string());
            test = jsonObj.getJSONObject("success").getString("success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (test.equals("true")){


            utilisateurs.setNom(nom);
            utilisateurs.setPrenom(prenom);
            utilisateurs.setAdresse(adresse);
            utilisateurs.setCivilite("Mr");
            utilisateurs.setEmail(email);
            utilisateurs.setId_user(1);
            utilisateurs.setMdp(mdp);
            ClientLog.utilisateurs = utilisateurs;

            return true;
        }

        return false;
    }


    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

}

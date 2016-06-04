package fr.railcommandeer.app.entity;

import java.io.Serializable;
import java.util.Date;




public class
Deal implements Serializable {
    Long id;
    String image;
    String texte;

    public Long getId() {
        return id;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}

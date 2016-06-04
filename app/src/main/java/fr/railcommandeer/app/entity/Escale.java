package fr.railcommandeer.app.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexa on 04/06/2016.
 */

public class Escale implements Serializable{


    private int id;

    private List<Voyages> voyages;

    private List<Gare> gare;
}

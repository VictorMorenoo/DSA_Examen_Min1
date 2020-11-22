package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils; //Para id

//Caracteristicas
public class Track {

    String id;
    String title;
    String singer;


    //Constructor para inizializar
    public Track(String title, String singer)
    {
        this.id=RandomUtils.getId();
        this.setSinger(singer);
        this.setTitle(title);
    }

    public Track() {}

    //Getters and Setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString()
    {
        return "Track [id="+id+", title=" + title + ", singer=" + singer +"]";
    }

}
package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils; //Para id

import java.util.LinkedList;
import java.util.List;

public class Laboratorio {

    private String id;
    private String Nombre;

    //Muestras a analizar
    private List<Muestra> ListaMuestrasParaAnalizar=null;

    public Laboratorio (String Nombre)
    {
        this.id = RandomUtils.getId();
        this.Nombre = Nombre;
        this.ListaMuestrasParaAnalizar = new LinkedList<Muestra>();
    }

    public Laboratorio(){}

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public List<Muestra> getListaMuestrasParaAnalizar() {
        return ListaMuestrasParaAnalizar;
    }

    public void setListaMuestrasParaAnalizar(List<Muestra> listaMuestrasParaAnalizar) {
        ListaMuestrasParaAnalizar = listaMuestrasParaAnalizar;
    }

    @Override
    public String toString()
    {
        return "Persona [id="+ this.getId() +", Nombre=" + this.getNombre() + " ]";
    }
}

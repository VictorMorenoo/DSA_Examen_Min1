package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils; //Para id

//Caracteristicas
public class Muestra
{

    String id;
    String IdClinico;
    String IdPersona;
    String IdLaboratorio;

//Constructor
public Muestra(String IdClinico, String IdPersona, String IdLaboratorio)
{
    this.id = RandomUtils.getId();
    this.IdClinico = IdClinico;
    this.IdPersona = IdPersona;
    this.IdLaboratorio = IdLaboratorio;
}

    public Muestra(){}

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClinico() {
        return IdClinico;
    }

    public void setIdClinico(String idClinico) {
        IdClinico = idClinico;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String idPersona) {
        IdPersona = idPersona;
    }

    public String getIdLaboratorio() {
        return IdLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        IdLaboratorio = idLaboratorio;
    }


    @Override
    public String toString()
    {
        return "Muestra [id="+ this.getId() +", Clinico=" + this.getIdClinico() + ", Persona=" + this.getIdPersona() +", Laboratorio=" + this.getIdLaboratorio() +" ]";
    }
}

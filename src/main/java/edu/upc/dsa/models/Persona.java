package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils; //Para id

import java.util.LinkedList;
import java.util.List;

public class Persona {

    //Caracteristicas
    private String id;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private String Salud;  //A-D Siendo A menos enfermo

    //Muestras de Personas
    private List<Muestra> ListaMuestras=null;

    //Constructor
    public Persona(String Nombre, String  Apellido, int Edad, String Salud)
    {
        this.id = RandomUtils.getId();
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Salud = Salud;
        this.ListaMuestras = new LinkedList<Muestra>();
    }

    public Persona(){}

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

    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }
    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getSalud() {
        return Salud;
    }
    public void setSalud(String salud) {
        Salud = salud;
    }

    public List<Muestra> getListaMuestras() {
        return this.ListaMuestras;
    }
    public void setListaMuestras(List<Muestra> listaMuestras) {
        this.ListaMuestras = listaMuestras;
    }

    //Returns order's product list
    public List<Muestra> AñadirPersona(Muestra muestra){
        return this.ListaMuestras;
    }

    @Override
    public String toString()
    {
        return "Persona [id="+ this.getId() +", Nombre=" + this.getNombre() + ", Apellido=" + this.getApellido() +", Edad=" + this.getEdad() +",Salud=" + this.getSalud() +" ]";
    }
}

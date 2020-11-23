package edu.upc.dsa;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Laboratorio;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Covid19ManagerImpTest {

    public Covid19Manager manager = null;


    List<Persona> ListaPersonas;
    Persona persona;


    @Before
    public void setUp() throws Exception
    {
        manager = Covid19ManagerImpl.getInstance();
        ListaPersonas =  new LinkedList<Persona>();

        ListaPersonas.add(new Persona("Anto","bacallado",25,"C"));
        ListaPersonas.add(new Persona("julian","glz",20,"A"));

    }


    @Test
    //Test para añadir usuario
    public void AñadirPersona()
    {

        Assert.assertEquals(2, this.manager.ObtenerNumeroPersonas());
        persona = new Persona("suso","almandoz",10,"D");
        manager.AñadirPersona(persona);
        Assert.assertEquals(3, this.manager.ObtenerNumeroPersonas());
    }


    @Test
    //Test para añadir usuario
    public void ProcesarMuestra()
    {
        Assert.assertEquals(2, this.manager.ObtenerNumeroMuestras());

        Assert.assertEquals(3, this.manager.ObtenerNumeroMuestras());
    }



    @After
    public void tearDown() throws Exception
    {
        this.manager.LiberarRecursos();
    }

}

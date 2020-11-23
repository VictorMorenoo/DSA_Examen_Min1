package edu.upc.dsa;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Laboratorio;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;
    protected List<Persona> ListaPersonas;
    protected List<Laboratorio> ListaLaboratorios;
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);
    //HashMap
    private HashMap<String , Persona> DiccionarioPersona;
    private HashMap<String , Muestra> DiccionarioMuestra;
    private HashMap<String , Laboratorio> DiccionarioLaboratorio;

    //Singlenton
    private Covid19ManagerImpl()
    {
        this.ListaPersonas = new LinkedList<Persona>();
        this.ListaLaboratorios = new LinkedList<Laboratorio>();
        this.DiccionarioPersona = new HashMap<String,Persona>();
        this.DiccionarioMuestra = new HashMap<String,Muestra>();
        this.DiccionarioLaboratorio = new HashMap<String,Laboratorio>();

    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }

    //Añadir persona
    @Override
    public String AñadirPersona(String Nombre, String Apellido, int Edad, String Salud) {
        Persona persona = new Persona(Nombre,Apellido, Edad,Salud);
        this.AñadirPersona(persona);
        return persona.getId();
    }

    @Override
    public String AñadirPersona(Persona persona) {
        logger.info("Nuevo Paciente:"+persona);
        this.DiccionarioPersona.put(persona.getId(),persona);
        logger.info("Nuevo Paciente añadido");
        return persona.getId();
    }

    //Obtener muestra
    @Override
    public Muestra ObtenerMuestra(String id) {
        Muestra muestra = this.DiccionarioMuestra.get(id);
        logger.info("Obtener muestra("+id+")");
        if(muestra!=null) { logger.info("Muestra(" + id + "): " + muestra); }
        else{
            logger.error("No se ha encontrado " + id);
            return null;
        }
        return muestra;
    }

    //Añadir una muestra a una persona
    @Override
    public Persona AñadirMuestraPersona(String personaId, String muestraId) {
        Persona persona = this.ObtenerPersona(personaId);
        if(persona!=null){
            Muestra muestra = this.DiccionarioMuestra.get(muestraId);
            if(muestra!=null) {
                this.AñadirMuestraPersona(persona, muestra);
            }
        }
        else {
            logger.warn("Muestra no encontrada ");
            return null;
        }
        return persona;
    }

    @Override
    public Persona AñadirMuestraPersona(Persona persona, Muestra muestra) {
        logger.info("Muestra añadida");
        persona.AñadirPersona(muestra);
        return persona;
    }


    @Override
    public Laboratorio ProcesarMuestra(String id) {
        return null;
    }

    //Obtener muestras de un usuario
    @Override
    public List<Muestra> ObtenerMuestrasUsuario(String id) {
        int index = ListaPersonas.size();
        logger.info("Obtener Muestra("+id+")");
        for (int i = 0; i < ListaPersonas.size(); i++) {
            if (ListaPersonas.get(i).getId().equals(id)) {
                index = i;
            }
        }
        if (index != ListaPersonas.size()) {
            return (List<Muestra>) ListaPersonas.get(index);
        } else {
            logger.error("No se ha encontrado la muestra con id:"+id);
            return null;
        }
    }

    @Override
    public Persona ObtenerPersona(String id) {
        return null;
    }

    //Añadir lab
    @Override
    public String AñadirLaboratorio(Laboratorio lab) {
        logger.info("Añadir laboratorio " + lab);
        this.ListaLaboratorios.add(lab);
        logger.info("New order added");
        return lab.getId();
    }

    //Añadir muestra
    @Override
    public String AñadirMuestra(String IdClinico, String IdPersona, String IdLaboratorio) {
        Muestra muestra = new Muestra(IdClinico,IdPersona, IdLaboratorio);
        this.AñadirMuestra(muestra);
        return muestra.getId();
    }

    @Override
    public String AñadirMuestra(Muestra muestra) {
        logger.info("Nueva muestra:"+muestra);
        this.DiccionarioMuestra.put(muestra.getId(),muestra);
        logger.info("Nueva muestra añadido");
        return muestra.getId();
    }

    @Override
    public int ObtenerNumeroPersonas() {
        return this.DiccionarioPersona.size();
    }

    @Override
    public void LiberarRecursos() {

        this.ListaPersonas.clear();
        this.ListaLaboratorios.clear();
        this.DiccionarioPersona.clear();
        this.DiccionarioMuestra.clear();
        this.DiccionarioLaboratorio.clear();
    }

    @Override
    public int size() {
        return 0;
    }
}

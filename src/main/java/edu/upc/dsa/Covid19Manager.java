package edu.upc.dsa;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Laboratorio;
import java.util.List;

public interface Covid19Manager {

    //Añadir persona
    String AñadirPersona(String Nombre, String Apellido,int Edad, String Salud);
    String AñadirPersona(Persona persona);

    //Obtener muestra
    Muestra ObtenerMuestra(String id);

    //Añadir muestra a Laboratorio
    //String AñadirMuestraLaboratorio(String laboratorioId, String muestraId);
   // String AñadirMuestraLaboratorio(Laboratorio laboratorio, Muestra muestra);

    //Añadir muestra a Persona
    Persona AñadirMuestraPersona(String personaId, String muestraId);
    Persona AñadirMuestraPersona(Persona persona, Muestra muestra);

    //Obtener muestra de Laboratorio
    Laboratorio ProcesarMuestra(String id); // o lista

    //Listado de muestras de un usuario
    List<Muestra> ObtenerMuestrasUsuario(String id);

    //Obtener Persona
    Persona ObtenerPersona(String id);

    //Añadir Lab
    String AñadirLaboratorio(Laboratorio laboratorio);

    //Añadir muestra
    String AñadirMuestra(String IdClinico, String IdPersona, String IdLaboratorio);
    String AñadirMuestra(Muestra muestra);


    int ObtenerNumeroPersonas();

    // (Clear)
    void LiberarRecursos();

    int size();
}

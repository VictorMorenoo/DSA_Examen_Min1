package edu.upc.dsa.services;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;


import io.swagger.annotations.Api;
import org.apache.log4j.Logger;

import javax.ws.rs.Path;

//Swagger
@Api(value = "/Covid19", description = "Endpoint to Covid19 Service")
@Path("/Covid19")
public class Covid19Service {
    static final Logger logger = Logger.getLogger(Covid19Service.class);
    private Covid19Manager tm;

    public Covid19Service()
    {
        this.tm = Covid19ManagerImpl.getInstance();
        if (tm.size()==0) {

          /*  //Añadiendo canciones
            this.tm.AñadirPersona("Georgie Dann");
            this.tm.AñadirPersona("Luis Fonsi");
            this.tm.AñadirPersona("Metallica");*/
        }
    }


}

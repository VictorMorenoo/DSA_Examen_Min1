package edu.upc.dsa.services;


import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

//Swagger
@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")

public class TracksService {
    static final Logger logger = Logger.getLogger(TracksService.class);
    private TracksManager tm;


    public TracksService()
    {
        this.tm = TracksManagerImpl.getInstance();
        if (tm.size()==0) {

            //Añadiendo canciones
            this.tm.AñadirCancion("La Barbacoa", "Georgie Dann");
            this.tm.AñadirCancion("Despacito", "Luis Fonsi");
            this.tm.AñadirCancion("Enter Sandman", "Metallica");
        }
    }


    //Lista conciertos
    @GET
    @ApiOperation(value = "Mostrar todos los conciertos", notes = "Da lista conciertos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class, responseContainer="List"),
    })
    @Path("/listaConciertos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Track> Conciertos = this.tm.findAll();

        GenericEntity<List<Track>> entity = new GenericEntity<List<Track>>(Conciertos) {};
        return Response.status(201).entity(entity).build()  ;
    }

    //Canciones de un concierto
    @GET
    @ApiOperation(value = "Obtener todas las canciones de un concierto", notes = "Lista de canciones")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Tracks not found")
    })
    @Path("/listacanciones/{ConciertoID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("ConciertoID") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }


    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    //Actualizar cancion
    @PUT
    @ApiOperation(value = "Update cancion", notes = "Editar una cancion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/ActualizarCancion/{id}/{tittle}/{singer}")
    public Response updateTrack(@PathParam("id") String id,@PathParam("title") String title,@PathParam("singer") String singer)
    {
        Track t = this.tm.updateTrack(id,title,singer);
        if (t == null) return Response.status(404).build();
        return Response.status(201).build();
    }


    //Añadir una cancion
    @POST
    @ApiOperation(value = "Create a new Track", notes = "Añadir una nueva cancion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/AñadirCancion/{title}/{singer}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AñadirCancion( @PathParam("title") String title, @PathParam("singer") String singer ) {

        if (title.isEmpty() || singer.isEmpty())
            return Response.status(500).entity(new Track()).build();
        String TrackId =this.tm.AñadirCancion(title,singer);
        return Response.status(201).entity(tm.getTrack(TrackId)).build();
    }

}
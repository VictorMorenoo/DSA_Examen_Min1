package edu.upc.dsa;

import edu.upc.dsa.models.Track;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class TracksManagerImpl implements TracksManager {

    private static TracksManager instance;
    protected List<Track> Listatracks;
    final static Logger logger = Logger.getLogger(TracksManagerImpl.class);
    //HashMap
    private HashMap<String , Track> mapTrack;

    //Singlenton
    private TracksManagerImpl()
    {
        this.Listatracks = new LinkedList<Track>();
        this.mapTrack = new HashMap<String,Track>();
    }

    public static TracksManager getInstance() {
        if (instance==null) instance = new TracksManagerImpl();
        return instance;
    }

    public int size()
    {
        int ret = this.Listatracks.size();
        logger.info("size " + ret);

        return ret;
    }

    //Añadir cancion

    @Override
    public String AñadirCancion(Track t)
    {
        logger.info("new Cancion " + t);
        this.mapTrack.put(t.getId(),t);
        logger.info("new Track added");
        return t.getId();
    }
    @Override
    public String AñadirCancion(String title, String singer)
    {
        Track t = new Track(title,singer);
        this.AñadirCancion(t);
        this.AñadirCancion(t);
        return t.getId();
    }


    public Track getTrack(String id) {
        logger.info("getTrack("+id+")");

        for (Track t: this.Listatracks) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Track> findAll() {
        return this.Listatracks;
    }

    @Override
    public void deleteTrack(String id) {

        Track t = this.getTrack(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.Listatracks.remove(t);

    }

    //Update Track
    @Override
    public Track updateTrack(String id, String tittle, String singer)
    {
        Track t = this.mapTrack.get(id);

        if (t!=null)
        {
            logger.info(t+"Actualizar");
            t.setSinger(singer);
            t.setTitle(tittle);
            logger.info(t+"Actualizado");
        }
        else {
            logger.warn("No encontrado");
        }
        return t;
    }

    @Override
    public void clearResources()
    {
        this.Listatracks.clear();
        this.mapTrack.clear();
    }
}
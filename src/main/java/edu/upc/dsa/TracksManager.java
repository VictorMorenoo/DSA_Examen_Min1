package edu.upc.dsa;

import edu.upc.dsa.models.Track;

import java.util.List;

public interface TracksManager
{
    String AñadirCancion(String title, String singer);

    String AñadirCancion(Track t);

    Track getTrack(String id);

    List<Track> findAll();

    void deleteTrack(String id);

    Track updateTrack(String id, String tittle, String singer);

    int size();

    void clearResources();
}

package edu.upc.dsa;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import edu.upc.dsa.models.Track;
import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TracksManagerImplTest {

  /*  private HttpServer server;
    private WebTarget target; */

    public TracksManager manager = null;

    Track track;
    String trackId;

    List<Track> trackList;


    @Before
    public void setUp() throws Exception
    {
       /* // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();


        target = c.target(Main.BASE_URI);*/

        manager = TracksManagerImpl.getInstance();

        trackId = this.manager.AñadirCancion("La cancion", "J Balvin");
        track = this.manager.getTrack(trackId);

        this.manager.AñadirCancion("Monkey Business","Pet Shop Boys");

    }

   /* @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    } */

    @After
    public void tearDown() throws Exception
    {
        this.manager.clearResources();
    }
}

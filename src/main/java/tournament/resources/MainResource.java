package tournament.resources;


import tournament.views.MainView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class MainResource {

    public MainResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public MainView getMainView() {
        return new MainView();
    }
}
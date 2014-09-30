package tournament.resources;


import tournament.views.HomeView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

    public HomeResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public HomeView getHomeView() {
        return new HomeView();
    }
}

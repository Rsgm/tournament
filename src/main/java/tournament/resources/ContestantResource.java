package tournament.resources;

import io.dropwizard.views.View;
import tournament.db.ContestantDAO;
import tournament.views.ContestantView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/contestants/{id}")
public class ContestantResource {
    private final ContestantDAO contestantDAO;

    public ContestantResource(ContestantDAO contestantDAO) {
        this.contestantDAO = contestantDAO;
    }

    @GET
    @Path("/contestants/{id}")
    @Produces(MediaType.TEXT_HTML)
    public View getContestantView(@PathParam("id") String id) {
        return new ContestantView(contestantDAO.findById(Integer.parseInt(id)));
    }
}

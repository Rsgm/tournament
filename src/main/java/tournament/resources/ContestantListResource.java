package tournament.resources;

import io.dropwizard.views.View;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.views.ContestantListView;
import tournament.views.ContestantView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contestants")
public class ContestantListResource {
    private final ContestantDAO contestantDAO;

    public ContestantListResource(ContestantDAO contestantDAO) {
        this.contestantDAO = contestantDAO;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public View getContestantListView() {
        return new ContestantListView();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contestant> getContestantList() {
        return contestantDAO.findAll();
    }
}

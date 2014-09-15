package tournament.resources;

import com.google.common.base.Optional;
import io.dropwizard.views.View;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.views.ContestantView;
import tournament.views.NotFoundView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/contestant")
@Produces(MediaType.TEXT_HTML)
public class ContestantResource {
    private final ContestantDAO contestantDAO;

    public ContestantResource(ContestantDAO contestantDAO) {
        this.contestantDAO = contestantDAO;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public View getContestantView(@QueryParam("id") Optional<Integer> id) {
        if (id.isPresent()) {
            return new ContestantView(new Contestant(id.get(), contestantDAO.findNameById(id.get())));
        } else {
            return new NotFoundView();
        }
    }
}

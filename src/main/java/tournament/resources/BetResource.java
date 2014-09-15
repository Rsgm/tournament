package tournament.resources;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.views.BetView;
import tournament.views.ResultsView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



/*
 * legal notice: This shall not be used for betting with any form of currency nor any objects of value.
 */

@Path("/bet")
@Produces(MediaType.TEXT_HTML)
public class BetResource {
    private final ContestantDAO dao;

    public BetResource(ContestantDAO dao) {
        this.dao = dao;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public ResultsView register(@QueryParam("id1") Optional<Integer> id1, @QueryParam("id2") Optional<Integer> id2) {
        double random = Math.random();

        int d1 = dao.findDifficultyById(id1.get());
        int d2 = dao.findDifficultyById(id2.get());

        int winner = 0;
        if (d1 > d2) {
            winner = d2 / ((double) d1) >= random ? id2.get() : id1.get(); // horrible win calculator
        } else {
            winner = d1 / ((double) d2) >= random ? id1.get() : id2.get();
        }
        return new ResultsView(new Contestant(winner, dao.findNameById(winner)));
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public BetView getRegisterView() {
        return new BetView();
    }
}

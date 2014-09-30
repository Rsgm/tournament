package tournament.resources;

import com.google.common.base.Optional;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.db.UserDAO;
import tournament.views.BetView;
import tournament.views.ResultsView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/*
 * legal notice: This shall not be used for betting with any form of currency nor any objects of value.
 */

@Data
@Path("/bet")
@Produces(MediaType.TEXT_HTML)
public class BetResource {
    private final ContestantDAO contestantDAO;
    private final UserDAO userDAO;
    private boolean bettingOpen = false;

    @POST
    @Produces(MediaType.TEXT_HTML)
    public ResultsView register(@QueryParam("id1") Optional<Integer> id1, @QueryParam("id2") Optional<Integer> id2) {
        double random = Math.random();

        Contestant c1 = contestantDAO.findById(id1.get());
        Contestant c2 = contestantDAO.findById(id2.get());

        Contestant winner = null;
        if (c1.getDifficulty() > c2.getDifficulty()) {
            winner = c2.getDifficulty() / ((double) c1.getDifficulty()) / 2d >= random ? c2 : c1; // not as bad of a win calculator
        } else {
            winner = c1.getDifficulty() / ((double) c2.getDifficulty()) / 2d >= random ? c1 : c2;
        }
        return new ResultsView(winner);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public BetView getRegisterView() {
        return new BetView(bettingOpen);
    }

    public void openBetting() {
        bettingOpen = true;
    }
}

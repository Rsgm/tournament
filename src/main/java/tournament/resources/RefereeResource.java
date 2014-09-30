package tournament.resources;

import io.dropwizard.views.View;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.views.RefereeView;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/ref")
public class RefereeResource {
    private final ContestantDAO dao;
    private Map<String, Object> resourceMap;

    public RefereeResource(ContestantDAO dao, Map<String, Object> resourceMap) {
        this.dao = dao;
        this.resourceMap = resourceMap;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public View getRegisterView() {
        return new RefereeView();
    }

    @POST
    @Path("/ref/next_round")
    public void startNextRound() {

    }

    @POST
    @Path("/ref/start")
    public void startTournament() {
        ((RegisterResource) resourceMap.get("register")).closeRegistration();

        List<Contestant> contestants = dao.findAll();
        List<Contestant> shuffledContestants = new ArrayList<>();
        int[] opponents = new int[contestants.size()];

        // shuffle and match the contestants
        for (int i = 0; i < contestants.size(); i++) {
            int opponent = 0;
            do {
                opponent = (int) (Math.random() * (contestants.size() - i + 1)) + i + 1;
            } while (Arrays.binarySearch(opponents, opponent) >= 0);
        }

        ((BetResource) resourceMap.get("bet")).openBetting();
    }

}

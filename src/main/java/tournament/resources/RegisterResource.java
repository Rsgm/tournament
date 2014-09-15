package tournament.resources;

import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.views.RegisterView;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/register")
@Produces(MediaType.TEXT_HTML)
public class RegisterResource {
    private final AtomicLong counter;
    private final String defaultName = "Unknown";
    private final ContestantDAO dao;

    public RegisterResource(ContestantDAO dao) {
        this.dao = dao;
        this.counter = new AtomicLong();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Contestant register(Contestant contestant) {
        int id = (int) counter.incrementAndGet();
        System.out.println("New contestant " + id + "  -  " + contestant.getName());
        dao.insert(id, contestant.getName());
        return contestant;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public RegisterView getRegisterView() {
        return new RegisterView();
    }
}

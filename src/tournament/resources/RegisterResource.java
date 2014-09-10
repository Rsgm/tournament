package tournament.resources;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.views.RegisterView;

import javax.ws.rs.*;
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
    public Contestant register(@QueryParam("name") Optional<String> name) {
        Contestant contestant = new Contestant(counter.incrementAndGet(), name.or(defaultName));
        dao.insert((int) contestant.getId(), contestant.getName());
        System.out.println("New contestant " + contestant.getId() + "  -  " + contestant.getName());
        return contestant;
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public RegisterView getRegisterView() {
        return new RegisterView();
    }
}

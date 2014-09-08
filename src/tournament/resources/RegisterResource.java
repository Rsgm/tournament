package tournament.resources;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
public class RegisterResource {
    private final AtomicLong counter;
    private final String defaultName = "Unknown";
    private final ContestantDAO dao;

    public RegisterResource(ContestantDAO dao) {
        this.dao = dao;
        this.counter = new AtomicLong();
    }

    @GET
    @UnitOfWork
    public Contestant register(@QueryParam("name") Optional<String> name) {
        return dao.create(new Contestant(counter.incrementAndGet(), name.or(defaultName)));
    }
}

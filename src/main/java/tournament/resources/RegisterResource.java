package tournament.resources;

import lombok.Data;
import tournament.core.Contestant;
import tournament.core.User;
import tournament.db.ContestantDAO;
import tournament.db.UserDAO;
import tournament.views.RegisterView;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Path("/register")
@Produces(MediaType.TEXT_HTML)
public class RegisterResource {
    private final AtomicLong counter = new AtomicLong();
    private final String defaultName = "Unknown";
    private final ContestantDAO contestantDAO;
    private final UserDAO userDAO;
    private boolean registrationOpen = true;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User register(User user) {
        user.setId(counter.incrementAndGet());

        if (user.getContestant().getName().isEmpty()) {
            user.setContestant(null);
        }

        System.out.println("New user " + user.getId() + "  -  " + user.getName());
        contestantDAO.insert((int) user.getId(), user.getName(), (int) (Math.random() * 10));
        return user;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public RegisterView getRegisterView() {
        return new RegisterView(registrationOpen);
    }

    public void closeRegistration() {
        registrationOpen = false;
    }
}

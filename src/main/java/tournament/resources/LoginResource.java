package tournament.resources;

import lombok.Data;
import tournament.core.User;
import tournament.db.UserDAO;
import tournament.views.RegisterView;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Path("/login")
@Produces(MediaType.TEXT_HTML)
public class LoginResource {
    private final AtomicLong counter = new AtomicLong();
    private final UserDAO dao;
    private boolean registrationOpen = true;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User login(User user) {
        int id = (int) counter.incrementAndGet();
        user.setId(id);
        System.out.println("New User " + id + "  -  " + user.getName());
        dao.insert(id, user.getName(), user.getPassword());
        return user;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public RegisterView getLoginView() {
        return new RegisterView(registrationOpen);
    }
}

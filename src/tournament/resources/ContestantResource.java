package tournament.resources;

import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/people/{personId}")
@Produces(MediaType.APPLICATION_JSON)
public class ContestantResource {

    private final ContestantDAO contestantDAO;

    public ContestantResource(ContestantDAO contestantDAO) {
        this.contestantDAO = contestantDAO;
    }

    @GET
    @UnitOfWork
    public Contestant getPerson(@PathParam("personId") LongParam personId) {
        return findSafely(personId.get());
    }

    private Contestant findSafely(long personId) {
        final Optional<Contestant> contestant = contestantDAO.findById(personId);
        if (!contestant.isPresent()) {
            throw new NotFoundException("No such user.");
        }
        return contestant.get();
    }

//    @GET
//    @Path("/view_freemarker")
//    @UnitOfWork
//    @Produces(MediaType.TEXT_HTML)
//    public PersonView getPersonViewFreemarker(@PathParam("personId") LongParam personId) {
//        return new PersonView(PersonView.Template.FREEMARKER, findSafely(personId.get()));
//    }

}

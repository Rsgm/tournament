package tournament.db;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import tournament.core.Contestant;

import java.util.List;

public class ContestantDAO extends AbstractDAO<Contestant> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public ContestantDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public Optional<Contestant> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Contestant create(Contestant contestant) {
        return persist(contestant);
    }

    public List<Contestant> findAll() {
        return list(namedQuery("tournament.core.Contestant.findAll"));
    }
}

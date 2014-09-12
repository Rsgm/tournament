package tournament;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.skife.jdbi.v2.DBI;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.resources.BetResource;
import tournament.resources.ContestantResource;
import tournament.resources.RegisterResource;

public class Tournament extends Application<TournamentConfig> {

    public static void main(String[] args) throws Exception {
        new Tournament().run(args);
    }


    @Override
    public void initialize(Bootstrap<TournamentConfig> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(TournamentConfig configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final ContestantDAO dao = jdbi.onDemand(ContestantDAO.class);

        dao.createContestantsTable();

        environment.jersey().register(new RegisterResource(dao));
        environment.jersey().register(new ContestantResource(dao));
        environment.jersey().register(new BetResource(dao));
    }

    private final HibernateBundle<TournamentConfig> hibernate = new HibernateBundle<TournamentConfig>(Contestant.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(TournamentConfig configuration) {
            return configuration.getDataSourceFactory();
        }
    };
}

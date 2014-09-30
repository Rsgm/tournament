package tournament;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.oauth.OAuthProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.eclipse.jetty.server.Authentication;
import org.skife.jdbi.v2.DBI;
import tournament.auth.LoginAuth;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.db.UserDAO;
import tournament.resources.*;

import java.util.HashMap;
import java.util.Map;

public class Tournament extends Application<TournamentConfig> {

    public static void main(String[] args) throws Exception {
        new Tournament().run(args);
    }

    @Override
    public void initialize(Bootstrap<TournamentConfig> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle("/tournament/app", "/app", "index.htm", "app"));
    }

    @Override
    public void run(TournamentConfig configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final ContestantDAO contestantDAO = jdbi.onDemand(ContestantDAO.class);
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);

        contestantDAO.createContestantsTable();
        userDAO.createUserTable();

        Map<String, Object> resourceMap = new HashMap<>();

        resourceMap.put("main", new HomeResource());
        resourceMap.put("contestant", new ContestantResource(contestantDAO));
        resourceMap.put("contestantlist", new ContestantListResource(contestantDAO));
        resourceMap.put("register", new RegisterResource(contestantDAO, userDAO));
        resourceMap.put("bet", new BetResource(contestantDAO, userDAO));
        resourceMap.put("referee", new RefereeResource(contestantDAO, resourceMap));
        resourceMap.put("referee", new LoginResource(userDAO));

        for (Object resource : resourceMap.values()) {
            environment.jersey().register(resource);
        }

        environment.jersey().register(new OAuthProvider<Authentication.User>(new LoginAuth(),
                "SUPER SECRET STUFF"));
    }

    private final HibernateBundle<TournamentConfig> hibernate = new HibernateBundle<TournamentConfig>(Contestant.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(TournamentConfig configuration) {
            return configuration.getDataSourceFactory();
        }
    };
}

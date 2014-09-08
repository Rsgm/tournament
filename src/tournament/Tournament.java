package tournament;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.hibernate.SessionFactory;
import org.skife.jdbi.v2.DBI;
import tournament.core.Contestant;
import tournament.db.ContestantDAO;
import tournament.health.TemplateHealthCheck;
import tournament.resources.HelloWorldResource;
import tournament.resources.RegisterResource;

public class Tournament extends Application<TournamentConfig> {

    public static void main(String[] args) throws Exception {
        new Tournament().run(args);
    }


    @Override
    public void initialize(Bootstrap<TournamentConfig> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(TournamentConfig configuration, Environment environment) throws Exception {

        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        final ContestantDAO dao = new ContestantDAO(hibernateBundle.getSessionFactory());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(new RegisterResource(dao));
    }

    private final HibernateBundle<TournamentConfig> hibernateBundle = new HibernateBundle<TournamentConfig>(Contestant.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(TournamentConfig configuration) {
            return configuration.getDataSourceFactory();
        }
    };

}

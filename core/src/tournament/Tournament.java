package tournament;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Tournament extends Application<Tournament.TournamentConfig> {
    @Override
    public void initialize(Bootstrap<TournamentConfig> bootstrap) {

    }

    @Override
    public void run(TournamentConfig configuration, Environment environment) throws Exception {

    }

    protected class TournamentConfig extends Configuration {
        protected TournamentConfig() {

        }
    }
}

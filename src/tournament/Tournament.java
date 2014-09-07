package tournament;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import tournament.health.TemplateHealthCheck;
import tournament.resources.HelloWorldResource;

public class Tournament extends Application<TournamentConfig> {

    public static void main(String[] args) throws Exception {
        new Tournament().run(args);
    }


    @Override
    public void initialize(Bootstrap<TournamentConfig> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(TournamentConfig configuration, Environment environment) throws Exception {

        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }


}

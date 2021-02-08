package NLPService;

import NLPService.health.PingCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import NLPService.resources.*;

public class NLPServiceApplication extends Application<NLPServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NLPServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "NLPService";
    }

    @Override
    public void initialize(final Bootstrap<NLPServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final NLPServiceConfiguration configuration,
                    final Environment environment) {
        final SampleResource resource = new SampleResource();
        environment.jersey().register(resource);
        environment.healthChecks().register("ping", new PingCheck());
    }

}

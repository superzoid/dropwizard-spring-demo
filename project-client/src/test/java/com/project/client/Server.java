package com.project.client;

import com.project.resources.EchoResource;
import com.project.services.NameReversalService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
public class Server extends Application<Config> {

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
    }

    @Override
    public void run(Config configuration,
                    Environment environment) {
        environment.jersey().register(new EchoResource(new NameReversalService("bogus")));
    }

    public void start() throws Exception {
        final URL resource = getClass().getResource("/test-config.yml");
        log.warn("file={}", resource);
        final String file = resource.getFile();
        this.run(new String[]{"server", file});
    }

}

class Config extends Configuration {
}

import com.github.nhuray.dropwizard.spring.SpringBundle;
import com.project.RocketConfig;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application<RocketConfig> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void initialize(Bootstrap<RocketConfig> bootstrap) {
        bootstrap.addBundle(new SpringBundle(applicationContext(), true, true, true));
    }

    private ConfigurableApplicationContext applicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.project.services");
        context.scan("com.project.healthcheck");
        context.scan("com.project.resources");
        return context;
    }

    @Override
    public void run(RocketConfig configuration,
                    Environment environment) throws Exception {
    }
}

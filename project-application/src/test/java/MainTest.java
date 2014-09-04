import com.project.EchoRequest;
import com.project.EchoResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
public class MainTest {

    private static Main server;

    @BeforeClass
    public static void startServer() throws Exception {
        server = new Main();
        final String configfile = "/Users/a.macgilvery/projects/dropwizard-spring-demo/project-application/main.yml";
        server.run(new String[]{"server", configfile});
    }

    @AfterClass
    public static void stopServer() {
        server = null;
    }


    @Test
    public void testServer() {
        Client client = new Client();
        WebResource resource = client.resource("http://localhost:9090");
        final EchoRequest andyBackwards = new EchoRequest("ydna");
        final EchoResponse theExpectedResponse = new EchoResponse("andy");

        EchoResponse response = resource.path("demo").path("reverse").type(APPLICATION_JSON).post(EchoResponse.class, andyBackwards);

        assertThat(response, is(equalTo(theExpectedResponse)));
    }

}

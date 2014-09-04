package com.project.resources;

import com.project.EchoResponse;
import com.project.services.NameReversalService;
import com.sun.jersey.api.client.ClientResponse;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EchoResourceTest {
    private static final NameReversalService service = new NameReversalService("any");
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new EchoResource(service))
            .build();
    private static final String ANDY = "andy";
    private static final EchoResponse expectedResponse = new EchoResponse(ANDY);
    private static final EchoResource resource = new EchoResource(service);

    @Test
    public void testResource() throws InterruptedException {
        final EchoResponse actualResponse = resource.echo(ANDY);
        assertThat(expectedResponse, is(equalTo(actualResponse)));
    }

    @Test
    public void testResourceThroughClient() {
        final EchoResponse expectedResponse = new EchoResponse(ANDY);
        final EchoResponse actualResponse = resources.client().resource("/demo/echo/andy").get(EchoResponse.class);
        assertThat(actualResponse, is(equalTo(expectedResponse)));
    }

    @Test
    public void testResourceThroughClient2() {
        final ClientResponse actualResponse = resources.client().resource("/demo/echo/andy").get(ClientResponse.class);
        assertThat(actualResponse.getStatus(), is(equalTo(200)));
    }

}
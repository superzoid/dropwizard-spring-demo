package com.project.client;

import com.project.EchoResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JerseyEchoServiceClientTest {

    private static Server server;

    @BeforeClass
    public static void startServer() throws Exception {
        server = new Server();
        server.start();
    }

    @AfterClass
    public static void stopServer() {
        server = null;
    }


    @Test
    public void testClient() {
        JerseyEchoServiceClient client = new JerseyEchoServiceClient("http://localhost:9090");
        final EchoResponse andy = client.echo("andy");
        assertThat(andy.getResponse(), is(equalTo("andy")));
    }

}
package com.project.client;

import com.project.EchoResponse;
import com.sun.jersey.api.client.Client;

/**
 * Created by macgilverya on 03/07/2014.
 */
public class JerseyEchoServiceClient implements EchoServiceClient {

    final Client client;
    private final String endpoint;

    public JerseyEchoServiceClient(String endpoint) {
        this.endpoint = endpoint;
        client = new Client();
    }

    public EchoResponse echo(String toEcho) {
        return client
                .resource(endpoint)
                .path("/demo/echo/" + toEcho)
                .get(EchoResponse.class);
    }
}

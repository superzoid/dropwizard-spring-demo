package com.project.resources;

import com.codahale.metrics.annotation.Timed;
import com.project.EchoRequest;
import com.project.EchoResponse;
import com.project.services.NameReversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("/demo")
@Produces(APPLICATION_JSON)
@Controller
public class EchoResource {
    private final NameReversalService service;

    @Autowired
    public EchoResource(NameReversalService service) {
        this.service = service;
    }

    @GET
    @Path("/echo/{data}")
    @Timed
    @Produces({APPLICATION_JSON, APPLICATION_XML})
    public EchoResponse echo(@PathParam("data") String data) throws InterruptedException {
        return new EchoResponse(data);
    }

    @POST
    @Path("/reverse")
    @Timed
    public EchoResponse reverse(@Valid EchoRequest request) {
        return new EchoResponse(service.reverse(request.getRequest()));
    }
}

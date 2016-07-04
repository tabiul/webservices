package org.webservice.jaxrs;

import javax.ws.rs.*;

/**
 * Created by tabiul on 30 Jun 2016.
 */
@Path("/hello")
public class HelloResource {
    @GET
    @Produces("application/json")
    public Response getHello(@QueryParam("name") String name) {
        if (name != null) {
            return new Response("hello " + name);
        } else {
            throw new WebApplicationException("name is required", javax.ws.rs.core.Response.Status.NOT_ACCEPTABLE);
        }
    }
}

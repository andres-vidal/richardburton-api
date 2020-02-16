package br.edu.ifrs.canoas.richardburton.users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public interface UserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response create(User user);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieve();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieve(@PathParam("id") Long id);
}
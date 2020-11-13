package br.edu.ifrs.canoas.richardburton.auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/permissions")
public interface PermissionsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieve();
}

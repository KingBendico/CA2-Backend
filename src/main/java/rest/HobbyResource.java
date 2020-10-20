package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hobby")
public class HobbyResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHobbies(){
        return null;
    }
}
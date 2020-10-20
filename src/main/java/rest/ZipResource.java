package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("zip")
public class ZipResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getZips(){
        return null;
    }
}

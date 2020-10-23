package rest;

import Exceptions.EntityNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import facades.FacadePerson;
import utils.EMF_Creator;
// import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("persons")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    //commit me you fucking git

    private static final FacadePerson FACADE = FacadePerson.getFacadePerson(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String test() {
        return "{\"msg\":\"The API is up and running\"}";
    }

    @Path("/person/{phone}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPerson(@PathParam("phone") int phone) {
        return null;
    }

    @Path("/hobby/{hobby}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) throws EntityNotFoundException{
        List<PersonDTO> personList = FACADE.getPersonsByHobby(hobby);

        if(personList.isEmpty()){
            throw new EntityNotFoundException("The hobby you are looking for does not exist, or does not have any participants");
        }

        return Response.ok()
                .entity(GSON.toJson(personList))
                .build();

    }

    @Path("/zip/{zip}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersonsByZip(@PathParam("zip") String zip) throws EntityNotFoundException{
        List<PersonDTO> personList = FACADE.getPersonsByZip(zip);

        if(personList.isEmpty()){
            throw new EntityNotFoundException("The zip you are looking for does not exist, or does not have any residents");
        }

        return Response.ok()
                .entity( GSON.toJson(personList) )
                .build();
    }

    @Path("/add")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addPerson() {
        return null;
    }

    @Path("/edit/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response editPerson(@PathParam("id") int id) {
        return null;
    }
}

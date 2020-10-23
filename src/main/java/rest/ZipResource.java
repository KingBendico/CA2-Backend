package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CityInfoDTO;
import facades.FacadeCityInfo;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("zip")
public class ZipResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final FacadeCityInfo FACADE = FacadeCityInfo.getFacadeCityInfo(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getZips(){
        List<CityInfoDTO> zips = FACADE.getCityInfos();

        return Response.ok()
                .entity( GSON.toJson(zips) )
                .build();
    }
}

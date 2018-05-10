package de.gbsschulen.rest.world;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/citystore")
public class CityResource {

    private CityService cityService = new CityService();

    @GET
    @Path("/blub/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City getCity(@PathParam("id")int id){
        City city = cityService.getCity(id);
        return city;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

//    @GET
//    @Path("{start}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<City> getCitiyStart(@PathParam("start") int start){
//        return cityService.getCityStart(start);
//    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String deleteCity(@PathParam("id") int id){
        City city = cityService.deleteCity(id);
        if(city != null){
            return city.getName() + " wurde aus DB gelöscht";
        }
        return "nicht gelöscht!";
    }


}

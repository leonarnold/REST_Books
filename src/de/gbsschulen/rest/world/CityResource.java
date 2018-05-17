package de.gbsschulen.rest.world;


import com.sun.org.apache.xpath.internal.SourceTree;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/world")
public class Cityresource {

    private CityService cityService = new CityService();

    // http://localhost:8080/rest/bookstore/3

    @GET
    @Path("{ID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City getCity(@PathParam("ID") int id){
        City city = cityService.getCity(id);
        return city;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> getAllBooks(){
        return cityService.getAllCities();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{ID}")
    public String deleteBook(@PathParam("ID") int id){
        City city = cityService.deleteCity(id);
        if (city != null){
            return city.getName() + " wurde aus DB gelöscht";
        }
        return " nicht gelöscht";
    }


    // localhost:8080/rest/bookstore/book?id=2

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/city/")
    public City gibCity(@QueryParam("ID") int id){
        City city = cityService.getCity(id);
        return city;
    }



}

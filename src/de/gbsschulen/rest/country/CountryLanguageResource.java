package de.gbsschulen.rest.country;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/countrylanguage")
public class CountryLanguageResource {

    private CountryLanguageService countryLanguageService = new CountryLanguageService();

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CountryLanguage getCity(@PathParam("id")String id, @PathParam("id") String sprache){
        CountryLanguage countryLanguage = countryLanguageService.getCityLanguage(id, sprache);
        return countryLanguage;
    }

    // localhost:8080/rest/bookstore/book?id=2
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/cl/")
    public CountryLanguage gibCountryLanguage(@QueryParam("id") String id, @QueryParam("name")String name){
        CountryLanguage cityLanguage = countryLanguageService.getCityLanguage(id, name);
        return cityLanguage;
    }
}
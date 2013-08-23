package com.github.marceloverdijk.jersey2.spring3.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.github.marceloverdijk.jersey2.spring3.service.RandomService;

@Path("/hello")
@Component
public class HelloResource {

    private RandomService randomService;
    
    public HelloResource(RandomService randomService) {
        this.randomService = randomService;
    }
    
    @GET
    @Path("/greeting")
    @Produces(APPLICATION_JSON)
    public Response greeting() {
        return Response.ok().entity("Hello World!").build();
    }
    
    @GET
    @Path("/greeting/{firstname}/{lastname}")
    @Produces(APPLICATION_JSON)
    public JsonObject greeting(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname) {
        JsonObject json = Json.createObjectBuilder()
                .add("first_name", firstname)
                .add("last_name", lastname)
                .add("random", randomService.getRandomAlphabetic())
                .build();
        return json;
    }
    
    @GET
    @Path("/greetingException/{firstname}/{lastname}")
    @Produces(APPLICATION_JSON)
    public JsonObject greetingException(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname) {
        throw new IllegalStateException("The Truth Is Out There...");
    }
}

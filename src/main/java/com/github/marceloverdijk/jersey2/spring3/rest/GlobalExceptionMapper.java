package com.github.marceloverdijk.jersey2.spring3.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.github.marceloverdijk.jersey2.spring3.service.RandomService;

@Provider
@Component
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    private RandomService randomService;
    
    public GlobalExceptionMapper(RandomService randomService) {
        this.randomService = randomService;
    }
    
    @Override
    public Response toResponse(Exception e) {
        String random = randomService != null ? randomService.getRandomAlphabetic() : "";
        JsonObject json = Json.createObjectBuilder().add("random", random).build();
        return Response.status(Response.Status.BAD_REQUEST).entity(json).build();
    }
}

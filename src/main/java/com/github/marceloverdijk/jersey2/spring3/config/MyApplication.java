package com.github.marceloverdijk.jersey2.spring3.config;

import javax.json.stream.JsonGenerator;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.github.marceloverdijk.jersey2.spring3.rest.GlobalExceptionMapper;
import com.github.marceloverdijk.jersey2.spring3.rest.HelloResource;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        // exception handling
        register(GlobalExceptionMapper.class);
        // json generation
        property(JsonGenerator.PRETTY_PRINTING, true);
        register(JsonProcessingFeature.class);
        // resources
        register(HelloResource.class);
    }
}

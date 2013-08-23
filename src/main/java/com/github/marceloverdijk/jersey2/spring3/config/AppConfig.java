package com.github.marceloverdijk.jersey2.spring3.config;

import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.context.annotation.Bean;

import com.github.marceloverdijk.jersey2.spring3.rest.GlobalExceptionMapper;
import com.github.marceloverdijk.jersey2.spring3.rest.HelloResource;
import com.github.marceloverdijk.jersey2.spring3.service.CommonsLang3RandomService;
import com.github.marceloverdijk.jersey2.spring3.service.RandomService;

public class AppConfig {

    @Bean
    public RandomService randomService() {
        return new CommonsLang3RandomService();
    }

    @Bean
    public ExceptionMapper<?> exceptionMapper() {
        return new GlobalExceptionMapper(randomService());
    }

    @Bean
    public HelloResource helloResource() {
        return new HelloResource(randomService());
    }
}

package com.geowarin.rest;

import com.geowarin.domain.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/")
@Singleton
@Component
public class RestResource {

    List<Message> messages = Collections.synchronizedList(new ArrayList<>());

    @PostConstruct
    public void init() {
        messages.add(new Message("Joe", "Hello"));
        messages.add(new Message("Jane", "Spring boot is cool !"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public String hello() {
        return "Hello World";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messages")
    public List<Message> message() {
        System.out.println(messages);
        return messages;
    }
}

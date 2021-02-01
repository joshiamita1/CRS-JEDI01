package com.dropwizard.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class HelloRestController {
	
	 @GET
	 @Path("/hello")
	 @Produces(MediaType.APPLICATION_JSON)
	    public String getEmployees() {
	        return "my dropwizard service";
	    }

}
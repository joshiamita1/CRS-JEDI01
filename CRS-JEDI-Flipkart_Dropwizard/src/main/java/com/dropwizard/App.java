package com.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dropwizard.rest.HelloRestController;
import com.flipkart.RESTController.*;


/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
       
        e.jersey().register(new HelloRestController());
        e.jersey().register(new AdminRESTAPI());
        e.jersey().register(new ProfessorRESTAPI());
        e.jersey().register(new StudentRESTAPI());
        //All the rest services register here using this syntax 
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
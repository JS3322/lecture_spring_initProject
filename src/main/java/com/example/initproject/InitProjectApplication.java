package com.example.initproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InitProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(InitProjectApplication.class, args);

        SpringApplication application = new SpringApplication(InitProjectApplication.class);

//        //Not web
//        application.setWebApplicationType(WebApplicationType.NONE);
//        //MVC
//        application.setWebApplicationType(WebApplicationType.SERVLET);
//        //WebFlux
//        application.setWebApplicationType(WebApplicationType.REACTIVE);
    }

}

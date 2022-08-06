package com.example.initproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//244~252
@SpringBootApplication
public class A05Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(A05Application.class);
        //내장톰캣 구동하지 않음
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}

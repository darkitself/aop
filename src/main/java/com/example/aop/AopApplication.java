package com.example.aop;

import com.example.aop.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {
    private static Service helpfulService;
    private static Service uselessService;

    public AopApplication(Service helpfulService, Service uselessService) {
        AopApplication.helpfulService = helpfulService;
        AopApplication.uselessService = uselessService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
        helpfulService.say();
        uselessService.say();
    }

}

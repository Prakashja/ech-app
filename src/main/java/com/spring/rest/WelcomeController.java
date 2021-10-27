package com.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {

    @GetMapping("/info")
    public String getMe() {
         return "{ service_name: app,  Version: 1.0.0.0, environment: { service_port: 8090 } }";
    }
    
    @GetMapping("/wish")
    public String getWish() {
	    return "Welcome to DevOps World";
    }

    @GetMapping("/status")
    public String getStutus() {
        return "Ok";
    }

}

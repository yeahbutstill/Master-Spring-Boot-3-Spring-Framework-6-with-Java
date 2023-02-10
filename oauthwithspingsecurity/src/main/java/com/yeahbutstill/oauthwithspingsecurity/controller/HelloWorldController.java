package com.yeahbutstill.oauthwithspingsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/oauth")
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String helloWorld(Authentication authentication) {

        logger.info("is authenticated {}", authentication.isAuthenticated());
        logger.info("authorities {}", authentication.getAuthorities());
        logger.info("principal {}", authentication.getPrincipal());
        logger.info("credentials {}", authentication.getCredentials());
        logger.info("details {}", authentication.getDetails());

        return "Hello World v3";
    }

}

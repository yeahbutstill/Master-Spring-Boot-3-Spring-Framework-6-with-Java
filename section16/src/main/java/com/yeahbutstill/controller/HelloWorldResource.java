package com.yeahbutstill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class HelloWorldResource {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

}

package com.yeahbutstill.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/hello-world")
public class HelloWorldController {
	
	@GetMapping(path = "/say")
	public String helloWorld() {
		return "Hello World"; 
	}
	
	@GetMapping(path = "/say-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World"); 
	}
	
	@GetMapping(path = "/say-path-variable/{username}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String username) {
		return new HelloWorldBean(String.format("Hello World, %s", username));
	}	
}

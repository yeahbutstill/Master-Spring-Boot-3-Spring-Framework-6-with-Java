package com.yeahbutstill.controller;

import com.yeahbutstill.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(value = "/api/v1/hello")
public class HelloWorldResource {

    private final MessageSource messageSource;

    @Autowired
    public HelloWorldResource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World v2";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean v2");
    }

    // Path parameter
    // /yser/{id}/todos/{id} => /users/1/todos/101
    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/dani
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello " + name);
    }

    @GetMapping(path = "/hello-world-international")
    public String helloWorldInternationalized() {
        // en, nl, fr, de
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}

package com.yeahbutstill;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App02GamingBasic {

    public static void main(String[] args) {
        // 1: Launch a spring context
        var context = new AnnotationConfigApplicationContext(App02Configuration.class);

        // 2: Configure the things that we want spring to manage - @Configuration
        // App02Configuration - @Configuration
        // name - @Bean

        // 3: Retrieve beans managed by spring
        context.getBean("name");
        context.getBean("age");
        context.getBean("person");
        context.getBean("address");

    }

}

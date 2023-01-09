package com.yeahbutstill;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App02GamingBasic {

    public static void main(String[] args) {
        // 1: Launch a spring context
        var context = new AnnotationConfigApplicationContext(App02Configuration.class);

        // 2: Configure the things that we want spring to manage - @Configuration
        // App02Configuration - @Configuration
        // name - @Bean

        // 3: Retrieve beans managed by spring name of bean
        System.out.println("context.getBean(\"name\") = " + context.getBean("name"));
        System.out.println("context.getBean(\"age\") = " + context.getBean("age"));
        System.out.println("context.getBean(\"person1\") = " + context.getBean("person1"));
        System.out.println("context.getBean(\"person2\") = " + context.getBean("person2"));
        System.out.println("context.getBean(\"person3MethodCall\") = " + context.getBean("person3MethodCall"));
        System.out.println("context.getBean(\"person4Parameters\") = " + context.getBean("person4Parameters"));

        // parsing with a class - default singleton
        System.out.println("context.getBean(Address.class) = " + context.getBean(Address.class));
        System.out.println("context.getBean(\"person6ParametersQualifier\") = " + context.getBean("person6ParametersQualifier"));

        System.out.println("====================================================");

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }

}

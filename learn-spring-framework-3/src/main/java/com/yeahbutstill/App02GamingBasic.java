package com.yeahbutstill;

import com.yeahbutstill.data.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class App02GamingBasic {

    public static void main(String[] args) {
        // 1: Launch a spring context
        var context = new AnnotationConfigApplicationContext(App02Configuration.class);

        // 2: Configure the things that we want spring to manage - @Configuration
        // App02Configuration - @Configuration
        // name - @Bean

        // 3: Retrieve beans managed by spring name of bean
        log.info("context.getBean(\"name\") = " + context.getBean("name"));
        log.info("context.getBean(\"age\") = " + context.getBean("age"));
        log.info("context.getBean(\"person1\") = " + context.getBean("person1"));
        log.info("context.getBean(\"person2\") = " + context.getBean("person2"));
        log.info("context.getBean(\"person3MethodCall\") = " + context.getBean("person3MethodCall"));
        log.info("context.getBean(\"person4Parameters\") = " + context.getBean("person4Parameters"));

        // parsing with a class - default singleton
        log.info("context.getBean(Address.class) = " + context.getBean(Address.class));
        log.info("context.getBean(\"person6ParametersQualifier\") = " + context.getBean("person6ParametersQualifier"));

        log.info("====================================================");

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }

}

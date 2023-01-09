package com.yeahbutstill.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class DILauncherApplication {

    public static void main(String[] args) {


        try {
            var context = new AnnotationConfigApplicationContext(DILauncherApplication.class);
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("context.getBean(\"yourBusiness\") = " + context.getBean("yourBusiness"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

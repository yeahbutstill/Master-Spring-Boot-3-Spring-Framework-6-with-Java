package com.yeahbutstill.examples.prepost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
@Slf4j
public class PrepostLauncherApplication {

    public static void main(String[] args) {

        try {
            var context = new AnnotationConfigApplicationContext(PrepostLauncherApplication.class);
            log.info("Initialization of context is completed");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(log::info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

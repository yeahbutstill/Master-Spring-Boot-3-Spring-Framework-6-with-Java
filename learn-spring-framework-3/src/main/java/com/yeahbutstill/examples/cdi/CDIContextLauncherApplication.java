package com.yeahbutstill.examples.cdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
@Slf4j
public class CDIContextLauncherApplication {

    public static void main(String[] args) {

        try {
            var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class);
            Arrays.stream(context.getBeanDefinitionNames()).forEach(log::info);
            log.info("context.getBean(BusinessService.class) = " + context.getBean(BusinessService.class).getDataService());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

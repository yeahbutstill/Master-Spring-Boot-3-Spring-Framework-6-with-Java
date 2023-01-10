package com.yeahbutstill.examples.prepost;

import com.yeahbutstill.examples.lazzy.BBB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@Slf4j
public class PrepostLauncherApplication {

    public static void main(String[] args) {

        try {
            var context = new AnnotationConfigApplicationContext(PrepostLauncherApplication.class);
            log.info("Initialization of context is completed");
            context.getBean(BBB.class).doSometing();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

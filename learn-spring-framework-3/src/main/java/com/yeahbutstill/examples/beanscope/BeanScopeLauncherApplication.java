package com.yeahbutstill.examples.beanscope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@Slf4j
public class BeanScopeLauncherApplication {

    public static void main(String[] args) {

        try {
            var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class);

            // singleton - one object instance per Spring IOC container
            log.info("context.getBean(NormalClass.class) = " + context.getBean(NormalClass.class));
            log.info("context.getBean(NormalClass.class) = " + context.getBean(NormalClass.class));
            log.info("context.getBean(NormalClass.class) = " + context.getBean(NormalClass.class));

            // prototype - possibly many object instance per Spring IOC container
            log.info("context.getBean(PrototypeClass.class) = " + context.getBean(PrototypeClass.class));
            log.info("context.getBean(PrototypeClass.class) = " + context.getBean(PrototypeClass.class));
            log.info("context.getBean(PrototypeClass.class) = " + context.getBean(PrototypeClass.class));
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(log::info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

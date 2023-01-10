package com.yeahbutstill.examples.xml;

import com.yeahbutstill.game.GameRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Slf4j
public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {

        try {
            var context = new ClassPathXmlApplicationContext("contextConfiguration.xml");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(log::info);
            log.info("context.getBean(\"name\") = " + context.getBean("name"));
            log.info("context.getBean(\"age\") = " + context.getBean("age"));
            log.info("context.getBean(GameRunner.class) = " + context.getBean(GameRunner.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

package com.yeahbutstill.examples.a1;

import com.yeahbutstill.game.GameRunner;
import com.yeahbutstill.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yeahbutstill.game")
public class DILauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(DILauncherApplication.class);
        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();

    }

}

package com.yeahbutstill;

import com.yeahbutstill.game.GameRunner;
import com.yeahbutstill.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBean {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Gaming03Configuration.class);
        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();

    }

}

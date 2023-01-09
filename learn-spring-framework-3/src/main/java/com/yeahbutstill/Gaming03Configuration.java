package com.yeahbutstill;

import com.yeahbutstill.game.GameRunner;
import com.yeahbutstill.game.GamingConsole;
import com.yeahbutstill.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Gaming03Configuration {

    @Bean
    public GamingConsole game() {
        return new PacmanGame();
    }

    @Bean
    public GameRunner runner(GamingConsole game) {
        return new GameRunner(game);
    }

}

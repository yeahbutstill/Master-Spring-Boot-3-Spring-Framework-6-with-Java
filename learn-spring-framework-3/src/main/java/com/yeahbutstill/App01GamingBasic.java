package com.yeahbutstill;

import com.yeahbutstill.game.GameRunner;
import com.yeahbutstill.game.PacmanGame;

public class App01GamingBasic {

    public static void main(String[] args) {

//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame(); // 1: Object Create
        var gameRunner = new GameRunner(game); // 2: Object Create + Wiring of Dependencies, Game is a Dependencies of GameRunner
        gameRunner.run();

    }

}

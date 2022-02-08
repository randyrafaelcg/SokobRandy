package com.company;

import com.company.console.util.InputReader;
import com.company.model.Level;
import com.company.play.LevelGenerator;
import com.company.play.PlayLevel;

import java.util.Vector;

public class GamePlay {

    private PlayLevel game;
    private Vector<Level> levels;
    private LevelGenerator newGame;

    public GamePlay() {
        newGame=new LevelGenerator();
        levels=newGame.getLevels();
    }

    public void process(){
        intro();
        char dir;
        for(Level lvl:levels){
            game=new PlayLevel(lvl);
            while(!game.isLevelOver()){
                game.print();
                System.out.print("Direction (wasd) ");
                dir=InputReader.readOption();
                game.movePlayer(dir);
            }
            game.print();
            lvlComplete();
        }
        gameEnded();
    }

    private void intro(){
        System.out.println("Welcome to Sokoban");
        InputReader.enterKey();
    }

    private void lvlComplete(){
        System.out.println("Level Cleared");
        InputReader.enterKey();
    }

    private void gameEnded(){
        System.out.println("\n\n\n\nCongratulation you finished the game\n\n\n");
        InputReader.enterKey();
    }
}

package com.company;

import com.company.model.Level;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    static void enterKey(){
        System.out.println("Press \"ENTER\" to start...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void main(String[] args) {
	    System.out.println("Hello World");
        PlayLevel game;
        LevelGenerator newGame=new LevelGenerator();
        Vector<Level> levels=newGame.getLevels();
        Scanner scan=new Scanner(System.in);
        char dir;
        //game=new PlayLevel(1,1);
        enterKey();
        for(Level lvl:levels){
            game=new PlayLevel(lvl);
            while(!game.isLevelOver()){
                game.print();
                System.out.print("Ingrese direccion (wasd): ");
                dir=scan.next().charAt(0);
                game.movePlayer(dir);
            }
        }
    }
}

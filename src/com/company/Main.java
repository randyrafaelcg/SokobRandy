package com.company;

import java.util.Scanner;

public class Main {

    static void enterKey(){
        System.out.println("Press \"ENTER\" to start...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void main(String[] args) {
	    System.out.println("Hello World");
        GamePlay game;
        Scanner scan=new Scanner(System.in);
        char dir;
        game=new GamePlay(1,1);
        enterKey();
        while(!game.isGameOver()){
            game.print();
            System.out.print("Ingrese direccion (wasd): ");
            dir=scan.next().charAt(0);
            game.movePlayer(dir);
        }
    }
}

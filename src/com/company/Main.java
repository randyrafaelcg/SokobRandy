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
        while(true){
            game.print();
            System.out.print("Ingrese direccion (wasd): ");
            dir=scan.next().charAt(0);
            game.movePlayer(dir);
        }


//        char[][] board={{' ',' '},
//                        {' ',' '}};
//        Player player=new Player(0,0);
//        board[player.getPosY()][player.getPosX()]=player.getId();
//        for (char[] c: board) {
//            for(char elem:c){
//                System.out.print(elem);
//            }
//            System.out.println();
//
//        }
//        player.move('d',board[player.getPosY()][player.getPosX()+1]);
//        board[player.getPosY()][player.getPosX()]=player.getId();
//        for (char[] c: board) {
//            for(char elem:c){
//                System.out.print(elem);
//            }
//            System.out.println();
//
//        }
    }
}

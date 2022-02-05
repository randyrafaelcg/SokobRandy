package com.company;

import com.company.model.BoardLevel;
import com.company.model.Box;
import com.company.model.Player;
import javafx.util.Pair;

import java.util.Vector;

public class GamePlay {
    private Player player;
    private Box box;
    private BoardLevel board;

    public GamePlay(int playerPosX, int playerPosY) {
        player=new Player(playerPosX, playerPosY);
        char [][] test=new char[][] {
            {'#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#'}};
        box=new Box(2,2);
        Vector<Pair<Integer,Integer>> prueba=new Vector<>();
        prueba.add((new Pair(1,2)));
        board= new BoardLevel(test,prueba);
        board.setChar(player.getId(), playerPosX,playerPosY);
        board.setChar(box.getId(), box.getPosX(), box.getPosY());
    }

    public void print(){
        board.print();
    }
    public void movePlayer(char dir){
        int x,y;
        switch (dir){
            case 'd':
                y=0;
                x=1;
                move(dir,x,y);
                break;
            case 'a':
                x=-1;
                y=0;
                move(dir,x,y);
                break;
            case 'w':
                y=-1;
                x=0;
                move(dir,x,y);
                break;
            case 's':
                y=1;
                x=0;
                move(dir,x,y);
                break;
            default:
                break;
        }
    }

    private void move(char dir, int x,int y) {
        char next;
        next=board.getChar(player.getPosX()+x, player.getPosY()+y);
        if(next==' ' || next=='o')
            moveP(dir);
        else if(next=='B' || next=='b'){
            next = board.getChar(box.getPosX()+x, box.getPosY()+y);
            if(next==' '){
                moveB(dir,false);
                moveP(dir);
            }
            else if(next=='o'){
                moveB(dir,true);
                moveP(dir);
            }
        }
    }

    private void moveP(char dir) {
        if(board.getObjectives().contains(new Pair(player.getPosX(),player.getPosY())))
            board.setChar('o', player.getPosX(), player.getPosY());
        else
            board.setChar(' ', player.getPosX(), player.getPosY());
        player.move(dir);
        board.setChar(player.getId(), player.getPosX(), player.getPosY());
    }

    private void moveB(char dir, boolean inPlace){
        board.setChar(' ', box.getPosX(), box.getPosY());
        box.move(dir, inPlace);
        board.setChar(box.getId(), box.getPosX(), box.getPosY());
    }

    public boolean isGameOver() {
        return board.isLevelOver();
    }
}

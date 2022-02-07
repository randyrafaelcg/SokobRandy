package com.company;

import com.company.model.Board;
import com.company.model.Box;
import com.company.model.Level;
import com.company.model.Player;
import javafx.util.Pair;

import java.util.Vector;

public class GamePlay {
    private Player player;
    private Board board;
    private Level level;

    public GamePlay(int playerPosX, int playerPosY) {
        char [][] test=new char[][] {
            {'#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#'}};
        player=new Player(playerPosX, playerPosY);
        Vector<Pair<Integer,Integer>> objetivos=new Vector<>();
        Vector<Pair<Integer,Integer>> coordenadas=new Vector<>();
        objetivos.add((new Pair(1,2)));
        objetivos.add(new Pair(1,3));
        coordenadas.add(new Pair(2,2));
        coordenadas.add(new Pair(2,3));
        level=new Level(player,objetivos,coordenadas);
        board= new Board(test,level.getObjectives());
        board.setChar(level.getPlayer().getId(),level.getPlayer().getPosX(),level.getPlayer().getPosY());
        for(Box b: level.getBoxes()){
            board.setChar(b.getId(),b.getPosX(),b.getPosY());
        }
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
        int nextX=player.getPosX()+x;
        int nextY=player.getPosY()+y;
        next=board.getChar(nextX, nextY);
        if(next==' ' || next=='o')
            moveP(dir);
        else if(next=='B' || next=='b'){
            Box b=level.getBoxByCoordinates(nextX,nextY);
            next = board.getChar(b.getPosX()+x, b.getPosY()+y);
            if(next==' '){
                moveB(b,dir,false);
                moveP(dir);
            }
            else if(next=='o'){
                moveB(b, dir,true);
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

    private void moveB(Box box, char dir, boolean inPlace){
        int actualX=box.getPosX();
        int actualY=box.getPosY();
        board.setChar(' ', actualX, actualY);
        box.move(dir, inPlace);
        board.setChar(box.getId(), box.getPosX(), box.getPosY());
        level.setNewBoxPosCoordinates(actualX,actualY,box.getPosX(),box.getPosY());
    }

    public boolean isGameOver() {
        return board.isLevelOver();
    }
}

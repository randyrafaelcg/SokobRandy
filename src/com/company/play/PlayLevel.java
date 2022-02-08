package com.company.play;

import com.company.model.Box;
import com.company.model.Level;
import javafx.util.Pair;

public class PlayLevel {
    private BoardUsage board;
    private Level level;

    public PlayLevel(Level level) {
        this.level=level;
        board= new BoardUsage(level.getBoard(),level.getObjectives());
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
        int nextX=level.getPlayer().getPosX()+x;
        int nextY=level.getPlayer().getPosY()+y;
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
        if(board.getObjectives().contains(new Pair(level.getPlayer().getPosX(),level.getPlayer().getPosY())))
            board.setChar('o', level.getPlayer().getPosX(), level.getPlayer().getPosY());
        else
            board.setChar(' ', level.getPlayer().getPosX(), level.getPlayer().getPosY());
        level.getPlayer().move(dir);
        board.setChar(level.getPlayer().getId(), level.getPlayer().getPosX(), level.getPlayer().getPosY());
    }

    private void moveB(Box box, char dir, boolean inPlace){
        int actualX=box.getPosX();
        int actualY=box.getPosY();
        board.setChar(' ', actualX, actualY);
        box.move(dir, inPlace);
        board.setChar(box.getId(), box.getPosX(), box.getPosY());
        level.setNewBoxPosCoordinates(actualX,actualY,box.getPosX(),box.getPosY());
    }

    public boolean isLevelOver() {
        return board.isLevelOver();
    }
}

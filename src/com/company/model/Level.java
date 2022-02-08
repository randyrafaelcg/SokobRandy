package com.company.model;

import com.company.model.Box;
import com.company.model.Player;
import javafx.util.Pair;

import java.util.Vector;

public class Level {
    private Player player;
    private Vector<Box> boxes;
    private Vector<Pair<Integer,Integer>> objectives;
    private Vector<Pair<Integer,Integer>> boxesCoordinates;
    private char[][] board;

    public Level(Player player, Vector<Pair<Integer, Integer>> objectives, Vector<Pair<Integer, Integer>> boxesCoordinates, char[][] board) {
        this.player = player;
        this.objectives = objectives;
        this.boxesCoordinates = boxesCoordinates;
        this.board=board;
        boxes=new Vector<>();
        for(Pair<Integer,Integer> xy: boxesCoordinates){
            Box newBox=new Box(xy.getKey(),xy.getValue());
            boxes.add(newBox);
        }
    }

    public char[][] getBoard() {return board;}
    public Player getPlayer() {return player;}
    public Vector<Box> getBoxes() {return boxes;}
    public Vector<Pair<Integer, Integer>> getObjectives() {return objectives;}
    public Vector<Pair<Integer, Integer>> getBoxesCoordinates() {return boxesCoordinates;}

    public Box getBoxByCoordinates(int x, int y){
        int pos=boxesCoordinates.indexOf(new Pair<>(x,y));//boxes and it's coordinates must have same position in vectors
        return boxes.get(pos);
    }

    public void setNewBoxPosCoordinates(int lastX, int lastY, int newX, int newY){
        int pos = boxesCoordinates.indexOf(new Pair<>(lastX,lastY));
        boxesCoordinates.set(pos, new Pair<>(newX, newY));
    }


}

package com.company.model;

import javafx.util.Pair;

import java.util.Vector;

public class Level {
    private final Player player;
    private final Vector<Box> boxes;
    private final Vector<Pair<Integer,Integer>> objectives;// In pair key is X and value is Y
    private final Vector<Pair<Integer,Integer>> boxesCoordinates;// In pair key is X and value is Y
    private final char[][] board;

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

    public Box getBoxByCoordinates(int x, int y){
        int pos=boxesCoordinates.indexOf(new Pair<>(x,y));//boxes and it's coordinates must have the same position in vectors
        return boxes.get(pos);
    }

    public void setNewBoxPosCoordinates(int lastX, int lastY, int newX, int newY){
        int pos = boxesCoordinates.indexOf(new Pair<>(lastX,lastY));
        boxesCoordinates.set(pos, new Pair<>(newX, newY));
    }


}

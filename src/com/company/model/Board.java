package com.company.model;

import javafx.util.Pair;

import java.util.Vector;

public class Board {
    private char[][] board;
    private Vector<Pair<Integer,Integer>> objectives;

    public Board(char[][] board, Vector<Pair<Integer, Integer>> objectives) {
        this.board = board;
        this.objectives = objectives;
        for(Pair<Integer,Integer> ob:objectives){
            board[ob.getValue()][ob.getKey()]='o';
        }
    }

    public Vector<Pair<Integer, Integer>> getObjectives() {
        return objectives;
    }

    public char getChar(int x, int y){
        try {
            return board[y][x];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 'e';
    }

    public void setChar(char id, int x, int y){
        try {
            board[y][x]=id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(){
        System.out.print("\n\n\n\n\n\n");
        for (char[] c:board) {
            for(char elem:c)
                System.out.print(elem+" ");
            System.out.println();
        }
    }

    public boolean isLevelOver(){
        for(char[] c:board){
            for(char elem:c){
                if(elem=='o' || elem == 'b'){
                    return false;
                }
            }
        }
        return true;
    }
}

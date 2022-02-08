package com.company.play;

import com.company.model.Level;
import com.company.model.Player;
import javafx.util.Pair;

import java.util.Vector;

public class LevelGenerator {
    final char[][] board1=new char[][] {
            {'#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#'}};//5x6
    final char[][] board2=new char[][] {
            {'#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#'}};//7x6
    final char[][] board3=new char[][] {
            {'#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#'}};//8x6
    private Vector<Level> levels;

    public LevelGenerator() {
        levels=new Vector<>();
        generateLevels();
    }

    public Vector<Level> getLevels() {
        return levels;
    }

    public void generateLevels(){
        //--------------Level 1------------
        Level lvl1;
        Player player1=new Player(1,1);
        Vector<Pair<Integer,Integer>> objectives1=new Vector<>();
        Vector<Pair<Integer,Integer>> boxesCoordinates1=new Vector<>();
        objectives1.add(new Pair<>(1,3));
        boxesCoordinates1.add(new Pair<>(1,2));
        lvl1=new Level(player1,objectives1,boxesCoordinates1,board1);
        levels.add(lvl1);
        //--------------Level 2------------
        Level lvl2;
        Player player2=new Player(1,1);
        Vector<Pair<Integer,Integer>> objectives2=new Vector<>();
        Vector<Pair<Integer,Integer>> boxesCoordinates2=new Vector<>();
        objectives2.add(new Pair<>(4,1));
        objectives2.add(new Pair<>(2,3));
        boxesCoordinates2.add(new Pair<>(4,2));
        boxesCoordinates2.add(new Pair<>(3,3));
        lvl2=new Level(player2,objectives2,boxesCoordinates2,board2);
        levels.add(lvl2);
        //--------------Level 3------------
        Level lvl3;
        Player player3=new Player(1,1);
        Vector<Pair<Integer,Integer>> objectives3=new Vector<>();
        Vector<Pair<Integer,Integer>> boxesCoordinates3=new Vector<>();
        objectives3.add(new Pair<>(4,6));
        objectives3.add(new Pair<>(4,1));
        objectives3.add(new Pair<>(1,6));
        boxesCoordinates3.add(new Pair<>(3,4));
        boxesCoordinates3.add(new Pair<>(3,1));
        boxesCoordinates3.add(new Pair<>(3,3));
        lvl3=new Level(player3,objectives3,boxesCoordinates3,board3);
        levels.add(lvl3);
    }
}

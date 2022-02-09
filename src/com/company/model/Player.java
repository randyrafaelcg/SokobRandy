package com.company.model;

public class Player {
    private int posX;
    private int posY;
    private final char id;

    public Player(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        id='P';
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public char getId() {
        return id;
    }

    public void move(char dir){
        switch (dir){
            case 'd':
                posX++;
                break;
            case 'a':
                posX--;
                break;
            case 'w':
                posY--;
                break;
            case 's':
                posY++;
                break;
            default:
                break;
        }
    }
}

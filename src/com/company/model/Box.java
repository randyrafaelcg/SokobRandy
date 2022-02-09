package com.company.model;

public class Box {
    private int posX;
    private int posY;
    private boolean inPlace;
    private char id;

    public Box(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        inPlace=false;
        id='b';
    }

    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public char getId() {return id;}

    public void move(char dir,boolean inPlace){
        this.inPlace=inPlace;
        if(inPlace)
            id='B';
        else
            id='b';
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

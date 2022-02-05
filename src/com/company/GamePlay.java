package com.company;

public class GamePlay {
    private Player player;
    private char[][] board;
    private Box box;

    public GamePlay(int playerPosX, int playerPosY) {
        player=new Player(playerPosX, playerPosY);
        box=new Box(2,1);
        board= new char[][]{
                {'#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}};
        board[playerPosX][playerPosY]= player.getId();
        board[box.getPosY()][box.getPosX()] = box.getId();
    }

    public void print(){
        for (char[] c:board) {
            for(char elem:c)
                System.out.print(elem+" ");
            System.out.println();
        }
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
                if(board[player.getPosY()][player.getPosX()-1]==' ') {
                    moveP(dir);
                }
                break;
            case 'w':
                if(board[player.getPosY()-1][player.getPosX()]==' ') {
                    moveP(dir);
                }
                break;
            case 's':
                if(board[player.getPosY()+1][player.getPosX()]==' ') {
                    moveP(dir);
                }
                break;
            default:
                break;
        }
    }

    private void move(char dir, int x,int y) {
        char next;
        next=board[player.getPosY()+y][player.getPosX()+x];
        if(next==' ')
            moveP(dir);
        else if(next=='B' || next=='b'){
            next = board[box.getPosY()][box.getPosX()+1];
            if(next==' '){
                moveB(dir,false);
                moveP(dir);
            }
        }
    }

    private void moveP(char dir) {
        board[player.getPosY()][player.getPosX()] = ' ';
        player.move(dir);
        board[player.getPosY()][player.getPosX()] = player.getId();
    }

    private void moveB(char dir, boolean inPlace){
        board[box.getPosY()][box.getPosX()] = ' ';
        box.move(dir, inPlace);
        board[box.getPosY()][box.getPosX()] = box.getId();
    }
}

package com.company;

public class GamePlay {
    private Player player;
    private char[][] board;
    private char[][] boardCopy;
    private Box box;

    public GamePlay(int playerPosX, int playerPosY) {
        player=new Player(playerPosX, playerPosY);
        box=new Box(2,1);
        board= new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', 'o', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#'}};
        boardCopy=new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', 'o', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#'}};
        board[playerPosX][playerPosY]= player.getId();
        board[box.getPosY()][box.getPosX()] = box.getId();
    }

    public void print(){
        System.out.print("\n\n\n\n\n\n");

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
        next=board[player.getPosY()+y][player.getPosX()+x];
        if(next==' ' || next=='o')
            moveP(dir);
        else if(next=='B' || next=='b'){
            next = board[box.getPosY()+y][box.getPosX()+x];
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
        if(boardCopy[player.getPosY()][player.getPosX()] =='o')
            board[player.getPosY()][player.getPosX()] = 'o';
        else
            board[player.getPosY()][player.getPosX()] = ' ';
        player.move(dir);
        board[player.getPosY()][player.getPosX()] = player.getId();
    }

    private void moveB(char dir, boolean inPlace){
        board[box.getPosY()][box.getPosX()] = ' ';
        box.move(dir, inPlace);
        board[box.getPosY()][box.getPosX()] = box.getId();
    }

    public boolean isGameOver() {
        for(char[] c:board){
            for(char elem:c){
                if(elem=='o' || elem == 'b'){
                    return true;
                }
            }
        }
        return false;
    }
}

package com.ENSF_TICTAC;

import java.util.Scanner;

/**
 *
 * players participating in the TicTacToe game
 */
public class Player implements Constants{

    /**
     *
     * players have a name, an opponent, and a mark
     * players use the playing board
     */
    private String name;
    private Board  board;
    private Player opponent;
    private char mark;

    /**
     *
     * creates a new player
     * @param name name of the player
     * @param mark mark of the player
     */
    Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    /**
     *
     * initiates the game
     */
    public void play(){
        while(true){
                this.makeMove();
                board.display();
                if(board.xWins() == true){
                    System.out.println("\nWinner: \n" + name);
                    System.exit(0);
                }
                if(board.isFull() == true){
                    System.out.println("\nTie Game!!!\n");
                    board.clear();
                    board.display();
                }
                    
                opponent.makeMove();
                board.display();
                if(board.oWins() == true){
                    System.out.println("\nWinner: \n" + name);
                    System.exit(0);
                }
                if(board.isFull() == true){
                    System.out.println("\nTie Game!!!\n");
                    board.clear();
                    board.display();
                }
        }
    }

    /**
     *
     * reads the players move
     */
    public void makeMove(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Turn: " + name + " Please enter a row");
        int row = Integer.parseInt(reader.nextLine());
        System.out.println("Turn: " + name + " Please enter a column");
        int col = Integer.parseInt(reader.nextLine());
        //reader.close();
        board.addMark(row, col, this.mark);
    }

    /**
     *
     * sets the players opponent
     * @param p opponent player
     */
    public void setOpponent(Player p){
        this.opponent = p;
    }

    /**
     *
     * sets the playing board
     * @param theboard the playing board
     */
    public void setBoard(Board theboard){
        this.board = theboard;
    }

    /**
     *
     * gets the name of the player
     * @return returns the name of the player
     */
    public String getName(){
        return this.name;
    }
}
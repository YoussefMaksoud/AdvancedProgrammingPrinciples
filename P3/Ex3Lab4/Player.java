package Ex3Lab4;

import java.util.Scanner;

/**
 *
 * players participating in the TicTacToe game
 */
public abstract class Player implements Constants{

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
    public abstract void play();

    /**
     *
     * reads the players move
     */
    public abstract void makeMove();

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

    public Board getBoard() {
        return board;
    }

    public Player getOpponent() {
        return opponent;
    }

    public char getMark() {
        return mark;
    }
}
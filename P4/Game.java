package com.ENSF_TICTAC;

import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 *
 * initiates TicTacToe game
 */
public class Game implements Constants {

	/**
	 *
	 * class has members  game board and  game referee
	 */
	private Board theBoard;
	private Referee theRef;

	/**
	 *
	 * constructs a new game
	 */
    public Game( ) {
        theBoard  = new Board();
	}

	/**
	 *
	 * sets a new referee for game
	 * @param r the referee
	 * @throws IOException handles input/ output exceptions
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }

	/**
	 *
	 * runs the program
	 * @param args command line arguments
	 * @throws IOException handles input/ output exceptions
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}

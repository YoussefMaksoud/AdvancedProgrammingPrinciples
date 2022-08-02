package EXE4;

import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 *
 * initiates TicTacToe game
 */
public class Game implements Constants, Runnable {

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
		theRef.setBoard(theBoard);
		theRef.getXplayer().setBoard(theBoard);
		theRef.getOplayer().setBoard(theBoard);
    }

	/**
	 *
	 * runs the runnable game
	 */
	@Override
	public void run() {

    	theRef.runTheGame();

	}
}

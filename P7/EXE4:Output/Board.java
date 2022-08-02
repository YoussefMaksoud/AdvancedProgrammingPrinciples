package EXE4;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 *
 * implements the tictactoe playing board
 */
public class Board implements Constants {

	/**
	 *
	 * the board keeps track of the number of marks on the playing board
	 * board has rows and columns
	 */
	private char theBoard[][];
	private int markCount;

	/**
	 *
	 * constructs playing board
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	public char[][] getTheBoard() {
		return theBoard;
	}

	/**
	 *
	 * returns the mark of the player (X or O)
	 * @param row vertical position of the mark
	 * @param col horizontal position of the mark
	 * @return returns the mark at the position (row, col)
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 *
	 * checks if the board is full
	 * @return returns true if board is full
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 *
	 * checks if the X player won
	 * @return returns true if player X is the winner
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 *
	 * checks if the O player won
	 * @return returns true if player O won
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 *
	 * creates a string storing the game board and sends it to the client to make a move
	 */
	public String display() {
		String board = "";
		board += displayColumnHeaders();
		board += addHyphens();
		for (int row = 0; row < 3; row++) {
			board += addSpaces();
			board += "    row " + row + ' ';
			for (int col = 0; col < 3; col++)
				board += "|  " + getMark(row, col) + "  ";
			board += "|\n";
			board += addSpaces();
			board += addHyphens();
		}

		return board;
	}

	/**
	 *
	 * adds a mark X or Y at the desired  board position
	 * @param row veritcal position of mark
	 * @param col horizontal position of mark
	 * @param mark mark is X or O
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 *
	 * clears the playing board
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 *
	 * checks for a winner after each move
	 * @param mark mark that is checked for win condition (X or O)
	 * @return returns true if there is a winner for the player who most recently played
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 *
	 * displays the column headers
	 */
	String displayColumnHeaders() {
		String headers = "";
		headers += "          ";
		for (int j = 0; j < 3; j++)
			headers = headers + "|col " + j;
		headers += "\n";

		return headers;
	}

	/**
	 *
	 * displays hyphens of board
	 */
	String addHyphens() {
		String hyphens = "";
		hyphens += "          ";
		for (int j = 0; j < 3; j++)
			hyphens+= "+-----";
		hyphens +="+\n";

		return hyphens;
	}

	/**
	 *
	 * spaces out the playing board
	 */
	String addSpaces() {
		String spaces = "";
		spaces += "          ";
		for (int j = 0; j < 3; j++) {
			spaces += "|     ";
		}

			spaces += "|\n";


		return spaces;
	}
}
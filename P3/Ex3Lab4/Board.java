package Ex3Lab4;

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
	 * displays the updated playing board
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 *
	 * adds a mark X or Y at the desired  board position
	 * @param row veritcal position of mark
	 * @param col horizontal position of mark
	 * @param mark mark is X or O
	 */
	public void addMark(int row, int col, char mark) {
		if(this.theBoard[row][col] == SPACE_CHAR) {
			theBoard[row][col] = mark;
			markCount++;
		}
		//else
			//System.out.println("Spot is taken, please enter another location\n");

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
	public int checkWinner(char mark) {
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
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 *
	 * displays hyphens of board
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 *
	 * spaces out the playing board
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}

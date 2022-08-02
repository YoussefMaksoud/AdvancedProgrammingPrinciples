package EXE4;

/**
 *
 * Referee of the TicTacToe game
 */
public class Referee{

    /**
     *
     * default constructor
     */
    public Referee(){}

    /**
     *
     * referee knows both the X and O players
     * monitors the game board
     */
    private Player xplayer;
    private Player oplayer;
    private Board board;

    /**
     *
     * runs the game by setting the players using the game thread
     */
    public void runTheGame(){
        xplayer.setOpponent(oplayer);
        oplayer.setOpponent(xplayer);

        xplayer.getPlayerName();
        oplayer.getPlayerName();

        board.display();
        xplayer.play();
    }

    /**
     *
     * sets the board
     * @param board playing board
     */
    public void setBoard(Board board){
        this.board = board;
    }

    /**
     *
     * sets the oplayer
     * @param oplayer the user of mark O
     */
    public void setoPlayer(Player oplayer){
        this.oplayer = oplayer;
    }

    /**
     * sets the xplayer
     * @param xplayer the user of mark X
     */
    public void setxPlayer(Player xplayer){
        this.xplayer = xplayer;
    }

    public Board getBoard() {
        return board;
    }

    public Player getOplayer() {
        return oplayer;
    }

    public Player getXplayer() {
        return xplayer;
    }
}
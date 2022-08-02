package EXE4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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
    private BufferedReader socketInput;
    private PrintWriter socketOutput;
    private Socket aSocket;

    /**
     *
     * creates a new BufferedReader and Printwriter for socket communication
     * @param s server socket
     * @param mark mark of the player
     */
    Player(Socket s, char mark){

        this.mark = mark;
        aSocket = s;

        try
        {
            socketInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
            socketOutput = new PrintWriter(s.getOutputStream(), true);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * returns the name of the player
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * initiates the game
     */
    public void play(){
        while(true){

            String boardLines = board.display();
            sendString(board.display());
            opponent.sendString(boardLines);

            if (board.xWins() == true) {
                sendString("\nWinner: \n" + opponent.getName());
                opponent.sendString("\nWinner: \n" + opponent.getName());
                opponent.sendString("quit");
                sendString("quit");
                break;
            }
            else if (board.oWins() == true) {
                sendString("\nWinner: \n" + name);
                opponent.sendString("\nWinner: \n" + name);
                opponent.sendString("quit");
                sendString("quit");
                break;
            }
            else if (board.isFull() == true) {
                sendString("\nTie Game!!!\n");
                opponent.sendString("\nTie Game!!!\n");
                board.clear();
                sendString(board.display());
                makeMove();
            }else{
                opponent.sendString("Please wait while opponent makes move...\n");
                makeMove();
            }

        }
    }

    /**
     *
     * reads the players move and send the board to the server
     */
    public void makeMove(){
        while(true) {
            try {
                sendString("Turn: " + name + " Please enter a row\0");
                int row = Integer.parseInt(socketInput.readLine());
                sendString("Turn: " + name + " Please enter a column\0");
                int col = Integer.parseInt(socketInput.readLine());
                if(board.getMark(row, col) == SPACE_CHAR) {
                    board.addMark(row, col, this.mark);
                    opponent.play();
                }else{
                    sendString("Please try again, this spot is taken\n");
                    play();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    public void getPlayerName(){
        try{

            sendString("Please enter name of " + mark + " player: \0");
            name = socketInput.readLine();

            while(name == null){
                sendString("Please try again \0");
                name = socketInput.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * sends a string as an input to the socket
     * @param toSend is the string to be sent
     */
    public void sendString(String toSend){
        socketOutput.println(toSend);
        socketOutput.flush();
    }
}
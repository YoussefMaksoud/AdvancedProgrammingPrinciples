package Ex3Lab4;

import java.util.Scanner;

public class HumanPlayer extends Player {
    /**
     * creates a new player
     *
     * @param name name of the player
     * @param mark mark of the player
     */
    HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void play(){
        while(true){
            this.makeMove();
            super.getBoard().display();
            if(super.getBoard().xWins() == true){
                System.out.println("\nWinner: \n" + super.getName());
                System.exit(0);
            }
            if(super.getBoard().isFull() == true){
                System.out.println("\nTie Game!!!\n");
                super.getBoard().clear();
                super.getBoard().display();
            }

            this.getOpponent().makeMove();
            super.getBoard().display();
            if(super.getBoard().oWins() == true){
                System.out.println("\nWinner: \n" + this.getOpponent().getName());
                System.exit(0);
            }
            if(super.getBoard().isFull() == true){
                System.out.println("\nTie Game!!!\n");
                super.getBoard().clear();
                super.getBoard().display();
            }
        }
    }

    /**
     *
     * reads the players move
     */
    @Override
    public void makeMove(){
        while(true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Turn: " + getName() + " Please enter a row");
            int row = Integer.parseInt(reader.nextLine());
            System.out.println("Turn: " + getName() + " Please enter a column");
            int col = Integer.parseInt(reader.nextLine());
            if (getBoard().getTheBoard()[row][col] == 'O' || getBoard().getTheBoard()[row][col] == 'X') {
                //System.out.println("Spot is taken, please enter another location\n");
                //System.out.println("tried spot" + row + " " + col + "Position was unavailable\n");
            } else {
                getBoard().addMark(row, col, getMark());
                break;
            }
        }
    }
}

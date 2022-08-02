package Ex3Lab4;

import java.util.Scanner;

public class RandomPlayer extends Player {

    RandomGenerator gen;

    /**
     * creates a new player
     *
     * @param name name of the player
     * @param mark mark of the player
     */
    RandomPlayer(String name, char mark) {
        super(name, mark);
        gen = new RandomGenerator();
    }

    @Override
    public void play() {
        while (true) {
            this.makeMove();
            super.getBoard().display();
            if (super.getBoard().xWins() == true) {
                System.out.println("\nWinner: \n" + super.getName());
                System.exit(0);
            }
            if (super.getBoard().isFull() == true) {
                System.out.println("\nTie Game!!!\n");
                super.getBoard().clear();
                super.getBoard().display();
            }

            super.getOpponent().makeMove();
            super.getBoard().display();
            if (super.getBoard().oWins() == true) {
                System.out.println("\nWinner: \n" + super.getOpponent().getName());
                System.exit(0);
            }
            if (super.getBoard().isFull() == true) {
                System.out.println("\nTie Game!!!\n");
                super.getBoard().clear();
                super.getBoard().display();
            }
        }
    }

    @Override
    public void makeMove() {
        while (true){
            System.out.println("Turn: " + getName() + " Please enter a row");
            int row = gen.discrete(0, 2);
            System.out.println(row);
            System.out.println("Turn: " + getName() + " Please enter a column");
            int col = gen.discrete(0, 2);
            System.out.println(col);
            if (getBoard().getTheBoard()[row][col] == 'O' || getBoard().getTheBoard()[row][col] == 'X') {
                System.out.println("tried spot" + row + " " + col + "Position was unavailable\n");
            } else {
                getBoard().addMark(row, col, getMark());
                break;
            }
        }
    }
}




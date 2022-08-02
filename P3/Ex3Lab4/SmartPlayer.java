package Ex3Lab4;

public class SmartPlayer extends BlockingPlayer {
    /**
     * creates a new player
     *
     * @param name name of the player
     * @param mark mark of the player
     */
    SmartPlayer(String name, char mark) {
        super(name, mark);
    }

        @Override
        public void makeMove() {
            while (true){
                int row = gen.discrete(0, 2);
                int col = gen.discrete(0, 2);

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++) {
                        if(testForBlocking(i, j) == true){
                            row = i;
                            col = j;
                        }
                    }
                }

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++) {
                        if(testForWinning(i, j) == true){
                            row = i;
                            col = j;
                        }
                    }
                }

                System.out.println("Turn: " + getName() + " Please enter a row");
                System.out.println(row);
                System.out.println("Turn: " + getName() + " Please enter a column");
                System.out.println(col);

                if (getBoard().getTheBoard()[row][col] == 'O' || getBoard().getTheBoard()[row][col] == 'X') {
                    //
                } else {
                    getBoard().addMark(row, col, getMark());
                    break;
                }
            }
        }

    public boolean testForWinning(int row, int col){
        Board temp = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp.getTheBoard()[i][j] = getBoard().getTheBoard()[i][j];
            }
        }

        temp.addMark(row, col, getMark());

        if (temp.checkWinner(getMark()) == 1) {
            return true;
        }

        return false;
    }
}

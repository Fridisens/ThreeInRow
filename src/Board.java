public class Board {

    //Instance variable for holding the symbol x and o on board
    private char[] board;

    //Constructor for initializing an empty board
    public Board() {
        board = new char[9];
        for (int i = 0; i < 9; i++){
            board[i] = ' ';
        }
    }
    //Method to check if cell on board is empty
    public boolean isCellEmpty (int move){
        return  board[move - 1] == ' ';
    }

    //Method to make a move by placing piece on the board (X or O)
    public void makeAMove(int move, char symbol) {
        board[move - 1] = symbol;
    }

    //Checks if we have a winner
    public boolean checkIfWin (char symbol){
        for (int[] winningCombination : WINNING_COMBINATIONS){
            if (board[winningCombination[0]] == symbol&&board[winningCombination[1]] == symbol && board[winningCombination[2]] == symbol){
                return true;
            }
        }
        return false;
    }

    //Check if the board is full and we have a draw
    public boolean isBoardFull(){
        for(char cell : board){
            if (cell == ' '){
                return false;
            }
        }//The board is full if all cells are occupied
        return true;
    }

    //Static final two-dimensional array to store winning combo
    private static final int [][] WINNING_COMBINATIONS = {
            //horizontal combo
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            //vertical combo
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            //diagonal combo
            {0, 4, 8}, {2, 4, 6}
    };

    //Method for printing board layout
    public void outprintBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + (board[0] == ' ' ? "1" : board[0]) + " | "
                + (board[1] == ' ' ? "2" : board[1]) + " | " + (board[2] == ' ' ? "3" : board[2])
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + (board[3] == ' ' ? "4" : board[3]) + " | "
                + (board[4] == ' ' ? "5" : board[4]) + " | " + (board[5] == ' ' ? "6" : board[5])
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + (board[6] == ' ' ? "7" : board[6]) + " | "
                + (board[7] == ' ' ? "8" : board[7]) + " | " + (board[8] == ' ' ? "9" : board[8])
                + " |");
        System.out.println("|---|---|---|");
    }
}


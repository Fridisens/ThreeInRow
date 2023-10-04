import java.util.*;
public class Board {

    //Instance variable
    private char[] board;


    public Board() {
        board = new char[9];
        for (int i = 0; i < 9; i++){
            board[i] = ' ';
        }
    }

    public boolean isCellEmpty (int move){
        return  board[move - 1] == ' ';
    }

    public void makeAMove(int move, char symbol) {
        board[move - 1] = symbol;
    }

    public boolean checkIfWin (char symbol){
        for (int[] winningCombination : WINNING_COMBINATIONS){
            if (board[winningCombination[0]] == symbol&&board[winningCombination[1]] == symbol && board[winningCombination[2]] == symbol){
                return true;
            }
        }
        return false;
    }


    public boolean isBoardFull(){
        for(char cell : board){
            if (cell == ' '){
                return false;
            }
        }
        return true;
    }

    private static final int [][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horisontella kombinationer
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertikala kombinationer
            {0, 4, 8}, {2, 4, 6} // Diagonala kombinationer
    };

    //Method for board layout
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


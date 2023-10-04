import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner inputFromPlayer = new Scanner(System.in);

        //create instance of Board
        Board board = new Board();

        System.out.println("Welcome to TicTacToe");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
        System.out.println();

        // Call method to print out board
        board.outprintBoard();

        //players turn to make a move
        boolean playerXTurn = true;

        while (true){
            System.out.println();
            System.out.println("Choose a number between 1-9 to make a move");
            int move = inputFromPlayer.nextInt();

            if (move >=1 && move <= 9 && board.isCellEmpty(move)){
                char symbol = playerXTurn ? 'X' : 'O';
                board.makeAMove (move,symbol);

                board.outprintBoard();

                if (board.checkIfWin(symbol)) {
                    System.out.println("Player " + symbol + " wins");
                    break;
                } else if (board.isBoardFull()){
                    System.out.println("DRAW");
                    break;

                }
                playerXTurn = !playerXTurn;

            } else {
                System.out.println("Invalid move, Try again");

            }

        }



    }


}








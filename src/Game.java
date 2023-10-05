import java.util.Scanner;

public class Game {

    public void play() {
        Scanner inputFromPlayer = new Scanner(System.in);

        // create instance of the board
        Board board = new Board();

        //Welcome message
        System.out.println("Welcome to TicTacToe");
        System.out.println();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
        System.out.println();

        // Call the method to print the game board
        board.outprintBoard();

        // Initialize a boolean for player x turn
        boolean playerXTurn = true;

        //Main game loop
        while (true) {
            System.out.println();

            //Prompt the current player to choose a number
            System.out.println("Choose a number between 1-9 to make a move");

            try {
                int move = inputFromPlayer.nextInt();
                //Check if entered move i do-able
                if (move >= 1 && move <= 9 && board.isCellEmpty(move)) {
                    char symbol = playerXTurn ? 'X' : 'O';

                    //Make a selected move on board
                    board.makeAMove(move, symbol);

                    //Display updated board
                    board.outprintBoard();

                    //Check if current player has won
                    if (board.checkIfWin(symbol)) {
                        System.out.println("Player " + symbol + " wins");
                        break;

                        //Checks for a draw
                    } else if (board.isBoardFull()) {
                        System.out.println("It's a draw, better luck next time");
                        break;
                    }

                    //Toogle the players turn between x and o
                    playerXTurn = !playerXTurn;
                } else {
                    System.out.println("Invalid move, Try again");
                }

                //handle invalid moves
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, try again to enter a number between 1-9");
                inputFromPlayer.next();
            }
        }
    }
}


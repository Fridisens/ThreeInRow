import java.util.Scanner;

public class Game {

    public void play() {
        Scanner inputFromPlayer = new Scanner(System.in);

        // Skapa en instans av Board
        Board board = new Board();

        System.out.println("Welcome to TicTacToe");
        System.out.println();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
        System.out.println();

        // Anropa metoden för att skriva ut spelbrädet
        board.outprintBoard();

        // Spelarnas tur att göra ett drag
        boolean playerXTurn = true;

        while (true) {
            System.out.println();

            System.out.println("Choose a number between 1-9 to make a move");

            try {
                int move = inputFromPlayer.nextInt();

                if (move >= 1 && move <= 9 && board.isCellEmpty(move)) {
                    char symbol = playerXTurn ? 'X' : 'O';
                    board.makeAMove(move, symbol);

                    board.outprintBoard();

                    if (board.checkIfWin(symbol)) {
                        System.out.println("Player " + symbol + " wins");
                        break;
                    } else if (board.isBoardFull()) {
                        System.out.println("It's a draw, better luck next time");
                        break;
                    }

                    playerXTurn = !playerXTurn;
                } else {
                    System.out.println("Invalid move, Try again");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, try again to enter a number between 1-9");
                inputFromPlayer.next();
            }
        }
    }
}


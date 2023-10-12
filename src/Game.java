import java.util.Scanner;

public class Game {
    //Instance variables
    private Scanner inputFromPlayer;
    private Board board;
    private boolean playerXTurn;

    private Player playerXName;
    private Player playerOName;

    //Constructor
    public Game(){
        inputFromPlayer = new Scanner(System.in);
        board = new Board();
        playerXName = new Player("");
        playerOName = new Player("");
        playerXTurn = true;

    }

    //Method for start game
    public void play() {
        //Welcome message
        System.out.println("Welcome to TicTacToe");
        System.out.println();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
        System.out.println();

        System.out.println("Enter name for Player X: ");
        String playerX = inputFromPlayer.nextLine();
        playerXName.setName(playerX);
        System.out.println("Enter name for Player O: ");
        String playerO = inputFromPlayer.nextLine();
        playerOName.setName(playerO);


        // Showing the empty board
        board.outprintBoard();

        //Main game loop
        while (true) {
            System.out.println();
            System.out.println((playerXTurn ? playerXName.getName() : playerOName.getName()) + "´s turn");

            //Ask the actual player for a number
            System.out.println("Choose a number between 1-9 to make a move");

            try {
                int move = inputFromPlayer.nextInt();

                //Control that the move is do-able
                if (move >= 1 && move <= 9 && board.isCellEmpty(move)) {
                    char symbol = playerXTurn ? 'X' : 'O';

                    //Make the selected move on board
                    board.makeAMove(move, symbol);

                    //Show updated board
                    board.outprintBoard();

                    //Check if current player has won
                    if (board.checkIfWin(symbol)) {
                        System.out.println((playerXTurn ? playerXName.getName() : playerOName.getName()) + " wins");

                        String answer;
                        System.out.println("You wanna play again? y/n");
                        Scanner playAgain = new Scanner(System.in);
                        answer = playAgain.nextLine();

                        if (answer.equalsIgnoreCase("y")) {
                            Game game = new Game();
                            game.play();
                        } else {
                            System.out.println("Thanks for playing, goodbye!");
                        }

                        break;

                        //Checks for a draw
                    } else if (board.isBoardFull()) {
                        System.out.println("It's a draw!");
                        String answer;
                        System.out.println("You wanna play again? y/n");
                        Scanner playAgain = new Scanner(System.in);
                        answer = playAgain.nextLine();
                        if (answer.equalsIgnoreCase("y")) {
                            Game game = new Game();
                            game.play();
                        } else {
                            System.out.println("Goodbye");
                        }
                        break;
                    }
                    //Toggle turns between x and o
                    playerXTurn = !playerXTurn;
                } else {
                    System.out.println("Invalid move, please try again");
                }
                //handle invalid moves
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, try again to enter a number between 1-9");
                inputFromPlayer.next();
            }
        }
    }
}







import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Board {
    private String[] board;

    public Board() {
        board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public void outprintBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
            + board[1] + " | " + board[2]
            + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
            + board[4] + " | " + board[5]
            + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
            + board[7] + " | " + board[8]
            + " |");
        System.out.println("|---|---|---|");
}




    }


package out;
import java.util.Scanner;
public class FourInARow {
    public static final String e = "\u001B[0m";
    public static final String blue = "\u001B[34m";
    public static final String red = "\u001B[31m";
    public static final String purple = "\u001B[35m";
    public static final String bold = "\u001B[1m";
    public static Scanner input = new Scanner(System.in);
    public static String[][] board = {{"F", "F", "F", "F", "F", "F", "F"}, {"F", "F", "F", "F", "F", "F", "F"}, {"F", "F", "F", "F", "F", "F", "F"}, {"F", "F", "F", "F", "F", "F", "F"}, {"F", "F", "F", "F", "F", "F", "F"}, {"F", "F", "F", "F", "F", "F", "F"}};
    public static void main(String[] args) {
        printBoard();
        int turn = 1;
        while (checkBoard().equals("nobody")) {
            System.out.print("\nPlayer " + turn + ": Where would you like to play? (1 - 7) ");
            String play = input.nextLine();
            System.out.println();
            while (!(play.equals("1") || play.equals("2") || play.equals("3") || play.equals("4") || play.equals("5") || play.equals("6") || play.equals("7"))) {
                System.out.println(red + bold + "Your answer must be a number 1 - 7!" + e);
                System.out.print("\nTry again player " + turn + ", where would you like to play? ");
                play = input.nextLine();
                System.out.println();
            }
            int column = Integer.parseInt(play) - 1;
            if (board[5][column].equals("F")) {
                if (turn == 1) {
                    board[5][column] = "X";
                    turn = 2;
                } else {
                    board[5][column] = "O";
                    turn = 1;
                }
            } else if (board[4][column].equals("F")) {
                if (turn == 1) {
                    board[4][column] = "X";
                    turn = 2;
                } else {
                    board[4][column] = "O";
                    turn = 1;
                }
            } else if (board[3][column].equals("F")) {
                if (turn == 1) {
                    board[3][column] = "X";
                    turn = 2;
                } else {
                    board[3][column] = "O";
                    turn = 1;
                }
            } else if (board[2][column].equals("F")) {
                if (turn == 1) {
                    board[2][column] = "X";
                    turn = 2;
                } else {
                    board[2][column] = "O";
                    turn = 1;
                }
            } else if (board[1][column].equals("F")) {
                if (turn == 1) {
                    board[1][column] = "X";
                    turn = 2;
                } else {
                    board[1][column] = "O";
                    turn = 1;
                }
            } else if (board[0][column].equals("F")) {
                if (turn == 1) {
                    board[0][column] = "X";
                    turn = 2;
                } else {
                    board[0][column] = "O";
                    turn = 1;
                }
            } else {
                System.out.println("You cannot play there!\n");
            }
            printBoard();
        }
        if (checkBoard().equals("X")) {
            System.out.print(red + "\nPlayer 1 wins!\n" + e);
        } else if (checkBoard().equals("O")){
            System.out.print(blue + "\nPlayer 2 wins!\n" + e);
        } else {
            System.out.print(purple + "\nIt's a tie!\n" + e);
        }
        System.out.print("\nType \"done\" to exit: ");
        String isDone = input.nextLine();
        while (!isDone.equals("done")) {
            System.out.print("Odd, I don't think \"" + isDone + "\" is the same thing as \"done\"\nTry again: ");
            isDone = input.nextLine();
        }
    }
    public static void printBoard() {
        System.out.println("  1 2 3 4 5 6 7");
        System.out.println("\u2554\u2550 \u2550 \u2550 \u2550 \u2550 \u2550 \u2550 \u2550\u2557");
        for (String[] row : board) {
            System.out.print("\u2551 ");
            for (String thing : row) {
                if (thing.equals("F")) {
                    System.out.print("  ");
                } else if (thing.equals("X")) {
                    System.out.print(red + "O " + e);
                } else {
                    System.out.print(blue + "O " + e);
                }
            }
            System.out.println("\u2551");
        }
        System.out.println("\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D");
    }
    public static String checkBoard() {
        // Horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board[i][j].equals("F") && board[i][j].equals(board[i][j + 1]) && board[i][j].equals(board[i][j + 2]) && board[i][j].equals(board[i][j + 3])) {
                    return board[i][j];
                }
            }
        }
        // Vertical
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!board[j][i].equals("F") && board[j][i].equals(board[j + 1][i]) && board[j][i].equals(board[j + 2][i]) && board[j][i].equals(board[j + 3][i])) {
                    return board[j][i];
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!board[2][i].equals("F")) {
                if (board[2][i].equals(board[3][i + 1]) && board[2][i].equals(board[4][i + 2]) && board[2][i].equals(board[5][i + 3])) {
                    return board[2][i];
                }
            } else if (!board[3][i].equals("F")) {
                if (board[3][i].equals(board[2][i + 1]) && board[3][i].equals(board[1][i + 2]) && board[3][i].equals(board[0][i + 3])) {
                    return board[3][i];
                }
            }
        }
        for (int i = 3; i < 7; i++) {
            if (!board[2][i].equals("F")) {
                if (board[2][i].equals(board[3][i - 1]) && board[2][i].equals(board[4][i - 2]) && board[2][i].equals(board[5][i - 3])) {
                    return board[2][i];
                }
            } else if (!board[3][i].equals("F")) {
                if (board[3][i].equals(board[2][i - 1]) && board[3][i].equals(board[1][i - 2]) && board[3][i].equals(board[0][i - 3])) {
                    return board[3][i];
                }
            }
        }
        boolean isTie = true;
        for (String[] row : board) {
            for (String col : row) {
                if (col.equals("F")) {
                    isTie = false;
                }
            }
        }
        if (isTie) {
            return "tie";
        }
        return "nobody";
    }
}

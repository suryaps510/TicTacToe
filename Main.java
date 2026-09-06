import java.util.*;

public class Main {

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    public static boolean checkWinner(char[][] board, char play) {

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == play && board[i][1] == play && board[i][2] == play) ||
                    (board[0][i] == play && board[1][i] == play && board[2][i] == play)) {
                return true;
            }
        }

        if ((board[0][0] == play && board[1][1] == play && board[2][2] == play) ||
                (board[0][2] == play && board[1][1] == play && board[2][0] == play)) {
            return true;
        }
        return false;

    }

    public static void createBoard(char board[][]) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = 'X';
        char play = c;
        boolean playAgain = false;
        char board[][] = new char[3][3];
        createBoard(board);
        System.out.println("Enter the number of players: ");
        int num_Of_Players = sc.nextInt();
        System.out.println("Number of players: " + num_Of_Players);
        int count = 0;
        int playerNo = 0;
        while (count < 9) {
            if (playerNo % 2 == 0) {
                System.out.println("Enter your position for player 1: ");
            } else {
                System.out.println("Enter your position for player 2: ");
            }
            int position = sc.nextInt();
            if (position < 1 || position > 9) {
                System.out.println("Invalid position. Please choose a position between 1 and 9.");
                continue;
            }
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;
            if (board[row][col] != ' ') {
                System.out.println("Position already taken. Please choose another position.");
            } else {
                playerNo++;
                board[row][col] = play;
                if (checkWinner(board, play)) {
                    System.out.println("Player " + play + " wins!");
                    printBoard(board);
                    playAgain = true;
                    break;
                } else {
                    if (play == 'X') {
                        play = 'O';
                    } else {
                        play = 'X';
                    }
                }
                printBoard(board);
                count++;

            }
        }
        if (!playAgain) {
            System.out.println("It's a draw!");
        }
        sc.close();
    }
}

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;

public class TicTacToeGUI {

    static char play = 'X';
    static boolean gameOver = false;
    static int count = 0;
    static int choice;

    public static void resetGame(char[][] board, JButton[][] button) {
        play = 'X';
        gameOver = false;
        count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
                button[i][j].setText("");
            }
        }
    }

    public static void userChoice(int choice, JFrame frame, char[][] board, JButton[][] button) {
        if (choice == JOptionPane.YES_OPTION) {
            resetGame(board, button);
        } else {
            frame.dispose();
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        char board[][] = new char[3][3];
        JButton button[][] = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                board[row][col] = ' ';
                button[row][col] = new JButton();
                frame.add(button[row][col]);
                button[row][col].addActionListener(e -> {
                    if (!gameOver && board[row][col] == ' ') {
                        button[row][col].setText(String.valueOf(play));
                        board[row][col] = play;
                        count++;

                        if (Main.checkWinner(board, play)) {
                            JOptionPane.showMessageDialog(frame, "Player " + play + " wins!");
                            gameOver = true;
                            choice = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", "Tic Tac Toe",
                                    JOptionPane.YES_NO_OPTION);
                            userChoice(choice, frame, board, button);

                        } else if (count == 9) {
                            JOptionPane.showMessageDialog(frame, "Game Over! It's a tie.");
                            gameOver = true;
                            choice = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", "Tic Tac Toe",
                                    JOptionPane.YES_NO_OPTION);
                            userChoice(choice, frame, board, button);
                        } else {
                            if (play == 'X') {
                                play = 'O';
                            } else {
                                play = 'X';
                            }
                        }
                    }
                });
            }
        }

        frame.setVisible(true);
    }
}
package game;

import java.util.Scanner;

public class TicTacTeo {
    public static void main(String[] args) {
        game();
    }

    static void game() {
        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " Enter your input:");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + "won");
                } else {
                    player = player == 'X' ? '0' : 'X';
                }
            } else {
                System.out.println("Invalid input try again");
            }

        }
        printBoard(board);
    }

    private static boolean hasWon(char[][] board, char player) {

//        Check rows
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
//        Check columns
        for (int i = 0; i < board.length; i++) {
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
        }

//        check diagnol
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        return false;
    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " |");
            }
            System.out.println();
        }
    }
}

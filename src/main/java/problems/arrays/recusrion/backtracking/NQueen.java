package problems.arrays.recusrion.backtracking;

public class NQueen {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        int res = queen(board,0);
        System.out.println(res);
    }

    static int queen(boolean[][] board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)){
                board[row][col] = true;
            }
            count = count+queen(board,row+1);
            board[row][col] = false;
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
//        check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }
//        Diagnol left
        for (int i=1;i<=Math.min(row,col);i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
//        Diagnol right
        for (int i=1;i<=Math.min(row,board.length-col-1);i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row:board){
            for(boolean el:row){
                if(el){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}

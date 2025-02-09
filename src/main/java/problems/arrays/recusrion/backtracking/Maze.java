package problems.arrays.recusrion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(countMaze(4,4));
//        pintMazePath("",3,3);
//        System.out.println(listMazePath("",3,3));
//        pintMazePathWithDiagnol("",3,3);

        boolean [][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] pathArray = new int[board.length][board[0].length];
//        System.out.println("----------");
//        pintMazePathRestriction("",board,0,0);
//        pintMazePathAllDirections("",board,0,0);
        pintMazePathAllDirectionsAsArray("",board,pathArray,1,0,0);
    }
    static int countMaze(int row,int col){
        if(row== 1|| col == 1){
            return 1;
        }
        int left = countMaze(row-1,col);
        int right = countMaze(row,col-1);
        return left+right;
    }

    static void pintMazePath(String processed, int row,int col){
        if(row==1 && col == 1){
            System.out.println(processed);
            return;
        }
        if(row>1){
            pintMazePath(processed+"D",row-1,col);
        }
        if(col>1){
            pintMazePath(processed+"R",row,col-1);
        }
    }

    static List<String> listMazePath(String processed, int row, int col){
        if(row==1 && col == 1){
            List<String> res = new ArrayList<>();
            res.add(processed);
            return res;
        }
        List<String> res = new ArrayList<>();
        if(row>1){
            res.addAll(listMazePath(processed+"D",row-1,col));
        }
        if(col>1){
            res.addAll(listMazePath(processed+"R",row,col-1));
        }
        return res;

    }

    static void pintMazePathWithDiagnol(String processed, int row,int col){
        if(row==1 && col == 1){
            System.out.println(processed);
            return;
        }
        if(row>1){
            pintMazePathWithDiagnol(processed+"D",row-1,col);
        }
        if(col>1){
            pintMazePathWithDiagnol(processed+"R",row,col-1);
        }
        if(col>1 && row>1){
            pintMazePathWithDiagnol(processed+"C",row-1,col-1);
        }
    }

    // start from 0 index
    static void pintMazePathRestriction(String processed,boolean[][] board, int row,int col){
        if(row == board.length-1 && col == board[0].length-1){
            System.out.println(processed);
            return;
        }
        if(!board[row][col]){
            return;
        }
        if(row < board.length-1){
            pintMazePathRestriction(processed+"D",board,row+1,col);
        }
        if(col < board[0].length-1){
            pintMazePathRestriction(processed+"R",board,row,col+1);
        }
    }

//    Back tracking
    static void pintMazePathAllDirections(String processed,boolean[][] board, int row,int col){
        if(row == board.length-1 && col == board[0].length-1){
            System.out.println(processed);
            return;
        }
        if(!board[row][col]){
            return;
        }
        board[row][col] = false;
//        Down
        if(row < board.length-1){
            pintMazePathAllDirections(processed+"D",board,row+1,col);
        }
//        Right
        if(col < board[0].length-1){
            pintMazePathAllDirections(processed+"R",board,row,col+1);
        }
//        UP
        if(row >0){
            pintMazePathAllDirections(processed+"U",board,row-1,col);
        }
//        Left
        if(col>0){
            pintMazePathAllDirections(processed+"L",board,row,col-1);
        }
//        revert the changes if its the same path
        board[row][col] = true;
    }

    static void pintMazePathAllDirectionsAsArray(String processed,boolean[][] board,int[][] pathArry,int step, int row,int col){
        if(row == board.length-1 && col == board[0].length-1){
            pathArry[row][col] = step;
            for (int[] r:pathArry){
                System.out.println(Arrays.toString(r));
            }
            System.out.println(processed);
            return;
        }
        if(!board[row][col]){
            return;
        }
        board[row][col] = false;
        pathArry[row][col] = step;
//        Down
        if(row < board.length-1){
            pintMazePathAllDirectionsAsArray(processed+"D",board,pathArry,step+1,row+1,col);
        }
//        Right
        if(col < board[0].length-1){
            pintMazePathAllDirectionsAsArray(processed+"R",board,pathArry,step+1,row,col+1);
        }
//        UP
        if(row >0){
            pintMazePathAllDirectionsAsArray(processed+"U",board,pathArry,step+1,row-1,col);
        }
//        Left
        if(col>0){
            pintMazePathAllDirectionsAsArray(processed+"L",board,pathArry,step+1,row,col-1);
        }
//        revert the changes if its the same path
        board[row][col] = true;
        pathArry[row][col] = 0;
    }
}

package problems.arrays.matrix;

import java.util.HashSet;
import java.util.Set;

public class MatrixZeros {
    public static void main(String[] args) {
        int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
        Matrix.printMatrix(input);
        setZeroes(input);
        Matrix.printMatrix(input);
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowsSet = new HashSet<>();
        Set<Integer> colsSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    rowsSet.add(i);
                    colsSet.add(j);
                }
            }
        }

        System.out.println(rowsSet);
        System.out.println(colsSet);

//        Marking rowsa as Zeros
        for (int rowNum: rowsSet) {
            for (int r=0;r<matrix[0].length;r++){
                matrix[rowNum][r] = 0;
            }
        }

        //        Marking cols as Zeros
        for (int colNum: colsSet) {
            for (int c=0;c<matrix.length;c++){
                matrix[c][colNum] = 0;
            }
        }
    }
}

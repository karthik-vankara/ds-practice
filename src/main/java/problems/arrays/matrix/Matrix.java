package problems.arrays.matrix;

public class Matrix {
    static void printMatrix(int[][] input){
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
    }
}

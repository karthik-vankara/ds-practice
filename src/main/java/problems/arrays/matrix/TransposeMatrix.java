package problems.arrays.matrix;

//works only for N*N matrix
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        transposeMatrix(input);
        Matrix.printMatrix(input);
    }

    private static void transposeMatrix(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        for(int i=0; i<rows-1;i++){
            for (int j=i+1; j<cols; j++) {
                swap(input,i,j);
            }
        }
    }

    private static void swap(int[][] input, int i, int j) {
        int temp = input[i][j];
        input[i][j] = input[j][i];
        input[j][i] = temp;
    }
}

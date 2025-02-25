package problems.arrays.matrix;

public class MatrixRotate90 {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

//        int[][] out = rotate(input);
//        Matrix.printMatrix(input);
//        System.out.println("After rotating");
//        Matrix.printMatrix(out);
        rotateMainArray(input);
    }

    public static int[][] rotate(int[][] input){
        int rows = input.length;
        int cols = input[0].length;
        int[][] out = new int[rows][cols];
        int counter = cols-1;
        for (int i=0;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                out[j][counter] = input[i][j];
            }
            counter--;
        }
        return out;
    }

    public static void rotateMainArray(int[][] input){
//        Step1 : transpose
        transpose(input);
        System.out.println("After transpose");
        Matrix.printMatrix(input);

//        Step2: Reverse row
        for (int[] row: input){
            reverse(row);
        }
        System.out.println("After Reverse");
        Matrix.printMatrix(input);
    }

    private static void transpose(int[][] input){
        int rows = input.length;
        int cols = input[0].length;
        for (int i = 0; i < rows-1; i++) {
            for (int j = i+1; j < cols; j++) {
                swap(input,i,j);
            }
        }
    }
    private static void swap(int[][] input, int i, int j) {
        int temp = input[i][j];
        input[i][j] = input[j][i];
        input[j][i] = temp;
    }

    private static void reverse(int[] row){
        int start = 0;
        int end = row.length-1;
        while (start <=end){
            int temp = row[start];
            row[start++] = row[end];
            row[end--] = temp;
        }
    }
}

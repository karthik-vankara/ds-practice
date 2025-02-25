package problems.arrays.matrix;

public class FindRotation {
    public static void main(String[] args) {
        FindRotation rotation = new FindRotation();
        int[][] input ={{1,1},{0,1}};
        int[][] target = {{1,1},{1,0}};
        System.out.println(rotation.findRotation(input,target));

    }
    public boolean findRotation(int[][] mat, int[][] target) {
        if(isBothArraysIdentical(mat,target)){
            return true;
        }else {
            for (int i = 1; i <= 3; i++) {
                transpose(mat);
                for(int[] row: mat){
                    reverse(row);
                }
                System.out.println("Rotation : "+i);
                Matrix.printMatrix(mat);
                if(isBothArraysIdentical(mat,target)){
                    return true;
                }
            }
            return false;
        }

    }

    private boolean isBothArraysIdentical(int[][] input, int[][] target){
        for (int i = 0; i < input.length ; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j] != target[i][j]){
                    return false;
                }
            }

        }
        return true;
    }

    private void transpose(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows-1 ; i++) {
            for (int j = i+1; j < cols; j++) {
                swap(matrix,i,j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void reverse(int[] row){
        int start = 0;
        int end = row.length-1;
        while (start <= end){
            int temp= row[start];
            row[start++] = row[end];
            row[end--] = temp;
        }
    }
}

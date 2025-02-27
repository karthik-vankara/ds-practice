package problems.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumInMatrix {
    public static void main(String[] args) {
        LuckyNumInMatrix test = new LuckyNumInMatrix();
        int[][] input = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        test.luckyNumbers(input);
        System.out.println();
    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int rowMinColIndex = getMin(matrix[i]);
            System.out.println("Row min ndex"+rowMinColIndex);
            boolean isMax = isIndexValueMaxInAllCols(rowMinColIndex,matrix,matrix[i][rowMinColIndex]);
            System.out.println("Is max :"+isMax);
            if(isMax){
                res.add(matrix[i][rowMinColIndex]);
            }
        }
        return res;
    }
    public int getMin(int[] arr){
        int minIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= arr[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }

    public boolean isIndexValueMaxInAllCols(int colIndex, int[][] matrix, int maxVal){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][colIndex]+"---"+maxVal);
            if(matrix[i][colIndex] > maxVal){
                return false;
            }
        }
        return true;
    }
}

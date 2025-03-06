package problems.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        List<Integer> res = SpiralMatrix.spiralOrder(mat);

        int[][] res = generateMatrix(3);
        Matrix.printMatrix(res);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0,
                top = 0,
                right = matrix[0].length - 1,
                bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
//        right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

//        bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

//            left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

//        top
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int counter = 0;
        int left = 0,
                top = 0,
                right = result[0].length - 1,
                bottom = result.length - 1;
        while (top <= bottom && left <= right) {
//        right
            for (int i = left; i <= right; i++) {
                result[top][i] = ++counter;
            }
            top++;

//        bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = ++counter;
            }
            right--;

//            left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = ++counter;
                }
                bottom--;
            }

//        top
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = ++counter;
                }
                left++;
            }
        }

        return result;
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> res = new ArrayList<>();
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};   // right, down, left, up
        int directionIndex = 0;
        int steps = 1;
        int x=rStart,y=cStart;

        while (res.size() < rows*cols){

//            Try moving in current direction
            for (int i = 0; i < steps; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res.add(new int[]{x, y});
                }
//                Move to next position
                x += directions[directionIndex][0];
                y += directions[directionIndex][1];
            }

//                Change direction
            directionIndex = (directionIndex +1) % 4;

            if(directionIndex % 2 == 0){
                steps++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

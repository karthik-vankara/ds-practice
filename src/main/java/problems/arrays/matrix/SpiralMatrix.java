package problems.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = SpiralMatrix.spiralOrder(mat);
        System.out.println(res);
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
}

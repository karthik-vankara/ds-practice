package problems.arrays.matrix;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MatrixReshape {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat; // Return original matrix if reshape is invalid
        }
        int[][] res = new int[r][c];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                list.add(mat[i][j]);
            }
        }
        int counter = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = list.get(counter++);
            }
        }

        return res;
    }

    public int[] plusOne(int[] digits) {
//        List<Integer> list = new ArrayList<>();
//
//        BigInteger prefixSum = new BigInteger("0");
//        for(int i=0;i<digits.length;i++){
//            prefixSum = prefixSum.multiply(BigInteger.TEN).add(BigInteger.valueOf(digits[i]));
//        }
//        BigInteger resSum = prefixSum.add(BigInteger.ONE);
//
//        while(!resSum.equals(BigInteger.ZERO)){
//            BigInteger last = resSum.remainder(BigInteger.TEN);
//            list.add(0,last.intValue());
//            resSum = resSum.divide(BigInteger.TEN);
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

}

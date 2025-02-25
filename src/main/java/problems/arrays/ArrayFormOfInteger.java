package problems.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ArrayFormOfInteger {
    public static void main(String[] args) {
        int[] nums ={9,9,9,9,9,9,9,9,9,9};
        System.out.println(ArrayFormOfInteger.addToArrayForm(nums,1));

    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        BigInteger mainNum = BigInteger.ZERO;
        for(int i=0;i<num.length;i++){
            mainNum = mainNum.multiply(BigInteger.TEN).add(BigInteger.valueOf(num[i]));
        }
        BigInteger resultNum = mainNum.add(BigInteger.valueOf(k));
        while (!resultNum.equals(BigInteger.ZERO)){
            BigInteger reminder = resultNum.remainder(BigInteger.TEN);
            result.add(0,reminder.intValue());
            resultNum = resultNum.divide(BigInteger.TEN);
        }
        return result;
    }
}

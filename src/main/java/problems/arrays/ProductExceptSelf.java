package problems.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] input = {-1,1,0,-3,3};
        int[] res = productExceptSelf(input);
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postFix = 1;

        for (int i = nums.length-1; i >=0 ; i--) {
            res[i] *= postFix;
            postFix *= nums[i];
        }

        return res;

    }
//    public static int[] productExceptSelf(int[] nums) {
//
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int iSum = 1;
//            for (int j = 0; j <nums.length ; j++) {
//                if(i!=j){
//                    iSum = iSum*nums[j];
//                }
//            }
//            res[i] = iSum;
//        }
//        return res;
//    }
}

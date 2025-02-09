package problems.arrays.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] nums = {8,5,3,10,35,2,1};
        System.out.println(Arrays.toString(nums));

        for(int i=0;i<nums.length;i++){
            boolean swapped = false;
            for(int j=1;j<nums.length-i;j++){
                if(nums[j] <nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

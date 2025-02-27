package problems.arrays.matrix;

public class MaxSubArraySum {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum,maxSum);
            }
        }
        return maxSum;
    }

// Kadanes alog states ignore sum if its negative
//
    public int maxSubArrayKadansAlgo(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < 0){
                sum=0;
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}

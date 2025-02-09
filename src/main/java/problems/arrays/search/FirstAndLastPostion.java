package problems.arrays.search;

import java.util.Arrays;

public class FirstAndLastPostion {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,78,8,10};
        int target = 7;

        int[] out = searchRange(nums,target);
        System.out.println("First postion: "+ Arrays.toString(out));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = getSearchIndex(nums,target,true);
        ans[1] = getSearchIndex(nums,target,false);

        return ans;
    }

    public static int getSearchIndex(int[] nums, int target, boolean isFirstPosition){
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;

        while (start <= end){
            int mid = start + (end-start)/2;
            if(target < nums[mid]){
                end = mid-1;
            } else if (target > nums[mid]) {
                start = mid+1;
            }else{
                ans = mid;
                if(isFirstPosition){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}

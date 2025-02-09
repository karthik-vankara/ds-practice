package problems.arrays.search;

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums = {2,5,8,9,22,30};
        int target = 25;
        int floor = getFloorNum(nums,target);
        int ceil = getCeilNum(nums,target);
        System.out.println("floor::"+nums[floor]);
        System.out.println("Ceil::"+nums[ceil]);
    }

    private static int getCeilNum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;
    }

    private static int getFloorNum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return end;
    }
}

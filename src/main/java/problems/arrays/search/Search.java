package problems.arrays.search;


public class Search {
    public static void main(String[] args) {
        int[] nums = {2,4,5,7,8,10,13,15};
        int target = 20;

//        int result = linearSearch(nums,target);
        int result = binarySearch(nums,target);
        if(result != -1){
            System.out.println("No found at : "+result);
        }else{
            System.out.println("Item not found");
        }
    }


    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        boolean isAsc = nums[left] < nums[right];
//        {2,4,6,8,9,115};
//        4
//        {10,9,8,7,5}
//        10
        while (left <= right){
            int mid = left+ (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target > nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }


        }
        return -1;
    }

    static int linearSearch(int[] nums, int target) {
         for (int i = 0; i < nums.length; i++) {
             if(nums[i] == target){
                 return i;
             }
         }
        return -1;
    }
}

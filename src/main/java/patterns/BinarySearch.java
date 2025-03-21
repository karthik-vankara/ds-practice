package patterns;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
//        System.out.println(binarySearch.search(new int[]{2, 5, 6, 8, 10, 11, 13, 14}, 1));
//        System.out.println(binarySearch.searchInsert(new int[]{1, 3, 5, 6}, 2));
//        System.out.println(binarySearch.firstBadVersion(5));
//        System.out.println(Arrays.toString(binarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(binarySearch.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(binarySearch.searchRotatedDuplicates(new int[]{4, 5, 6, 7, 0, 1, 1, 2}, 1));
//        System.out.println(binarySearch.findMin(new int[]{11, 13, 15, 17}));
//        System.out.println(binarySearch.findPeakElement(new int[]{1, 2, 3, 1}));
//        System.out.println(binarySearch.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
        System.out.println(binarySearch.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //    Given a sorted array of distinct integers and a target value,
//    return the index if the target is found.
//    If not, return the index where it would be if it were inserted in order.
    public int searchInsert(int[] nums, int target) {
        return binarySearchInsertIndex(nums, 0, nums.length - 1, target);
    }

    public int binarySearchInsertIndex(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int firstBadVersion(int n) {
        return firstBadVersionSearch(0, n - 1);
    }

    public int firstBadVersionSearch(int start, int end) {
        int version = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid + 1)) {
                version = mid + 1;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return version;
    }

    //    personal method to test it;
    private boolean isBadVersion(int num) {
        return num >= 4;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = getFirstOrLastIndex(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = getFirstOrLastIndex(nums, target, false);
        }
        return ans;
    }

    private int getFirstOrLastIndex(int[] nums, int target, boolean isFirstPosition) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (isFirstPosition) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public int searchRotated(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {   // left sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    //    returning index is not possible using binay search, need to use liner search
    public boolean searchRotatedDuplicates(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {    // ex: [1,0,1],[3,3,0,3,3,3] case this is the only condition need to be added
//                shrinking both left and right
                start = start + 1;
                end = end - 1;
            } else if (nums[start] <= nums[mid]) {   // left sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    //    get pivot or get where rotation is started
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            pick the min from sorted array
//            check in other half
            if (nums[start] <= nums[mid]) { // left half sorted
                minVal = Math.min(nums[start], minVal);
//                move to other half
                start = mid + 1;
            } else { // right is sorted
                minVal = Math.min(nums[mid], minVal);
                end = mid - 1;
            }
        }
        return minVal;
    }

    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

//            right neighbor greater
            if (mid < arr.length - 1 && arr[mid + 1] > arr[mid]) {
                start = mid + 1;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {    // left neighbor greater
                end = mid - 1;
            } else {
                return mid; // this case mid is greater than left and right
            }
        }
        return -1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        // our answer will not exceed > max element in the array
        // because elements > max sum will always < h, so we can ignore
        int end = getMaxNum(piles);
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sum = getSumByK(piles, mid);

            // success case need min hrs
            // search in first half
            if (sum <= h) {
                ans = mid;  //storing min value
                end = mid - 1;
            } else {    // search 2nd half
                start = mid + 1;
            }
        }
        return ans; // we can return start also
    }

    private int getMaxNum(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }
        return max;
    }


    private long getSumByK(int[] piles, int k) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            long result = piles[i] / k;
            long remainder = piles[i] % k;
            sum += remainder > 0 ? result + 1 : result;
        }
        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {

//        Capacity ranges
        int startRange = getMaxNum(weights);
        int endRange = getSum(weights);
        int minCapacity = 0;    // temp var maynot be usefull. just storing for testing purpose
        while (startRange <= endRange) {
            int midRange = startRange + (endRange - startRange) / 2;

            int daysForCapacity = getNoDaysByCapacity(weights, midRange);
            if (daysForCapacity <= days) {
                minCapacity = midRange;
                endRange = midRange - 1;
            } else {
                startRange = midRange + 1;
            }
        }
        return minCapacity; // we can directluy return startRange
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private int getNoDaysByCapacity(int[] weights, int capacity) {
        int days = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days = days + 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }
}

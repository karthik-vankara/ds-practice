package patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CyclicSort {
    public static void main(String[] args) {

        int[] input = {3, 5, 2, 1, 4};
        CyclicSort cyclicSort = new CyclicSort();


//        cyclicSort.sort(input);
//        System.out.println(Arrays.toString(input));

//        System.out.println(cyclicSort.missingNumber(new int[]{0, 1, 3}));
//        System.out.println(cyclicSort.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
//        System.out.println(cyclicSort.findDuplicate(new int[]{3, 1, 3, 4, 2}));
//        System.out.println(cyclicSort.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
//        System.out.println(Arrays.toString(cyclicSort.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(cyclicSort.firstMissingPositive(new int[]{1, 2, 0}));
    }

    public void sort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int correctIndex = arr[i] - 1;
//            while (arr[i] != arr[correctIndex]) {
//                swap(arr, i, correctIndex);
//                correctIndex = arr[i] - 1;
//            }
//        }
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int missingNumber(int[] nums) {
        int i = 0;
//        sort array based on index
        while (i < nums.length) {
            if (nums[i] != i && nums[i] != nums.length) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

//        find missing number based on index
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            } else {
                i++;
            }
        }
        // edge case [0,1]-> in this case 2 is missing so return length
        return nums.length;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
//        sort
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // find missing number based on index+1
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
            i++;
        }
        return res;
    }

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
            i++;
        }
        return -1;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
            i++;
        }
        return res;
    }

    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        int missing = 0;
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                duplicate = nums[i];
                missing = i + 1;
            }
            i++;
        }
        return new int[]{duplicate, missing};
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
//        sort array based on 1 index
//        1,2,0
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
//         search for 1st index
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}

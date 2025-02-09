package problems.arrays.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] nums = {8,5,3,10,35,2,1};
        selection(nums);
        System.out.println(Arrays.toString(nums));
    }
//    Find max element in arr and put it in the correct index
    public static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int lastInd = arr.length-i-1;
            int maxElement = getMaxElemt(arr,0,lastInd);
            swapElements(arr,maxElement,lastInd);
        }
    }

    private static void swapElements(int[] arr, int first, int sec) {
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }

    private static int getMaxElemt(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}

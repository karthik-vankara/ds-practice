package problems.arrays.search;

public class PeakIndexMountainArray {
    public static void main(String[] args) {
        int[] arr = {3,4,6,7,9,5,2,1};
        int peakIndex = getpeakIndex(arr);
        System.out.println(peakIndex);
    }
    public static int getpeakIndex(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int mid = start+ (end-start)/2;
            if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }else if(arr[mid] > arr[mid+1]) {
                end = mid;
            }
        }
        return start; //or end both are same

    }
}

package problems.arrays.search;

public class SearchInMountain {
    public static void main(String[] args) {
        int[] arr = {3,4,6,7,9,5,2,1};
        int target = 1;
        int res = search(arr,target);
    }

    public static int search(int[] arr, int target){
        int peakIndex = peak(arr);
        int searchIndex = binarySearch(arr,target,0,peakIndex );;
        if(searchIndex != -1){
            return searchIndex;
        }else {
            return binarySearch(arr,target,peakIndex+1,arr.length-1 );
        }
    }

    public static int peak(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int mid = start+ (end-start)/2;
            if (arr[mid] < arr[mid+1]){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }
    public static int binarySearch(int[] arr,int target, int start,int end){
//        {2,4,6,8,9,115};
//        9
//        {10,9,8,7,5}
//        10
        boolean isAsc = arr[start] < arr[end];
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target > arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}

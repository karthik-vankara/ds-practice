package problems.arrays.search;

public class SearchInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,9,115};
        int res = searchInfiniteArr(arr,100);
        System.out.println(res);
    }

    public static int searchInfiniteArr(int[] arr,int target){
        int start = 0;
        int end=1;

        int bucketSize =2;
        while (target > arr[end]){
            int temp = end + 1; // this is my new start
            end = (bucketSize*2)+start-1;
            start = temp;
        }
        return binarySearch(arr,target,start,end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end){
            int mid = start+ (end-start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }else if(target > arr[mid]){
                start = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}

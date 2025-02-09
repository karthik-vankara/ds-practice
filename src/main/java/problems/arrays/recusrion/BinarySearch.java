package problems.arrays.recusrion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,8,10,11,15};
        int target = 15;
        int result = search(arr,target,0,arr.length-1);
        System.out.println(result);

    }
    static int search(int[] arr, int target, int start,int end){
        int mid = start+ (end-start)/2;
        if(target == arr[mid]){
            return mid;
        }
        if(target < arr[mid]){
            return search(arr, target,start,mid-1);
        } else if (target > arr[mid]) {
            return search(arr,target,mid+1,end);
        }else {
            return -1;
        }
    }
}

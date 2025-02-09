package problems.arrays.recusrion;

public class FindElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 1;
        int out = linearSearch(arr,target,0);
        System.out.println(out);
    }

    private static int linearSearch(int[] arr, int target, int index) {
        if(index == arr.length-1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }else {
            return linearSearch(arr,target,index+1);
        }
    }
}

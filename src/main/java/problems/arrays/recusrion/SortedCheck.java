package problems.arrays.recusrion;

public class SortedCheck {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9,8};
        boolean res = sorted(arr,0);
        System.out.println(res);
    }

    private static boolean sorted(int[] arr, int index) {
        if(index == arr.length-1){
            return true;
        }
        if(arr[index] < arr[index+1] && sorted(arr,index+1)){
            return true;
        }else {
            return false;
        }
    }

}

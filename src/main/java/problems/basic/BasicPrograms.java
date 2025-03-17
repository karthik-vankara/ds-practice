package problems.basic;

import java.util.*;

public class BasicPrograms {
    public static void main(String[] args) {
        BasicPrograms basicPrograms = new BasicPrograms();
//        System.out.println(isArmstrong(123));
//        System.out.println(isPrime(10));
//        basicPrograms.printNos(10);
//        System.out.println(basicPrograms.SumNNums(5));
//        for (int i = 0; i < 10; i++) {
//            System.out.print(basicPrograms.fibanocci(i) + " ");
//        }
//        System.out.println(basicPrograms.fibanocci(5));
//        System.out.println(basicPrograms.frequencyCount(new int[]{2, 3, 2, 3, 5}));
        System.out.println(basicPrograms.maxSumSubArray(new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20},4));
    }

    public static boolean isArmstrong(int num){
        int tempNum = num;
        int count = 0;
        int sum = 0;
        while (tempNum != 0){
            count++;
            int lastIndex = tempNum %10;
            tempNum = tempNum/10;
        }
        tempNum = num;

        while (tempNum != 0){
            int lastIndex = tempNum %10;
            sum += Math.pow(lastIndex,count);
            tempNum = tempNum/10;
        }
        return sum == num;
    }
    public static boolean isPrime(int num){
        int count = 0;
//        Bruteforce
//        for (int i = 1; i <=num ; i++) {
//            if(num%i == 0){
//                count++;
//            }
//        }

//        Optimised
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num%i == 0){
                count++;
//                Second half
                if(i != num/i){
                    count++;
                }
            }
        }

        return count == 2;
    }

    public void printNos(int n) {
        // Your code here
        printNosHelper(n,1);
    }
    public void printNosHelper(int num, int current){
        if(current > num){
            return;
        }
        System.out.print(current);
        printNosHelper(num,current+1);
    }

    public int SumNNums(int num){
        return SumNNumsHelper(num,0);
    }

    private int SumNNumsHelper(int num, int sum) {
        if(num < 1){
            return sum;
        }
        return SumNNumsHelper(num-1,sum+num);
    }

    public int fibanocci(int num){

        if ( num <= 1){
            return num;
        }
        int last = fibanocci(num-1);
        int sencondLast = fibanocci(num-2);
        return last+sencondLast;
    }

//    Input: arr[] = [2, 3, 2, 3, 5]
//    Output: [0, 2, 2, 0, 1]
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int valueCount = map.getOrDefault(arr[i],0);
            map.put(arr[i],valueCount+1);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(i,map.getOrDefault(i+1,0));
        }
        return list;
    }

    public int maxSumSubArray(int[] nums, int k) {
        int windowSum = 0,maxSum=0;
        int left = 0,right = k-1;
        for (int i = 0; i < k; i++) {
            windowSum +=nums[i];
        }
        maxSum = windowSum;
        while (right < nums.length-1){
            windowSum -= nums[left];
            left++;
            right++;
            windowSum += nums[right];
            maxSum = Math.max(windowSum,maxSum);
        }
        System.out.println("sub array index["+left+","+right+"]");
        return maxSum;
    }
}

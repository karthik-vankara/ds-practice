package problems.arrays.recusrion;
public class Reverse {
    public static void main(String[] args) {
        reverse(1234);
        System.out.println(sum);
    }
    static int sum=0;
    static void reverse(int num){
        if(num == 0){
            return;
        }
        int rem = num%10;
        sum = (sum*10)+rem;
        reverse(num/10);
    }
}

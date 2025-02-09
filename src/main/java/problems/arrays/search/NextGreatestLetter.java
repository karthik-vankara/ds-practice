package problems.arrays.search;

public class NextGreatestLetter {
    public static void main(String[] args) {
    char[] letters = {'c','f','j'};
    char out = nextGreatestLetter(letters,'f');
        System.out.println(out);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start =0;
        int end = letters.length -1;


        while(start <= end){
            int mid = start + (end-start)/2;

            if(target < letters[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(start == letters.length){
            return letters[0];
        }else{
            return letters[start];
        }
    }
}

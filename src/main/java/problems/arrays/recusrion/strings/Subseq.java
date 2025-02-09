package problems.arrays.recusrion.strings;

import java.util.ArrayList;
import java.util.List;

public class Subseq {
    public static void main(String[] args) {
//        seq("abc","");
        List<String> res = sequences("abc","");
        System.out.println(res);
    }
    static void seq(String input, String processed){
        if(input.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = input.charAt(0);
//        Take it
        seq(input.substring(1),processed+ch);

//        Ignore it
        seq(input.substring(1),processed);
    }

    static List<String> sequences(String input,String processed){

        if(input.isEmpty()){
            List<String> res = new ArrayList<>();
            if(!processed.isEmpty()){
                res.add(processed);
            }
            return res;
        }
        char ch = input.charAt(0);
//        Take it
        List<String> left = sequences(input.substring(1),processed+ch);

//        Ignore it
        List<String> right = sequences(input.substring(1),processed);
        left.addAll(right);
        return left;
    }
}

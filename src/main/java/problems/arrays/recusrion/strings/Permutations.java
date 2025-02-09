package problems.arrays.recusrion.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
//        permutation("","abc");
        List<String> res = permutationList("","abc");
        System.out.println(res);
    }
    public static void permutation(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <=processed.length(); i++) {
            String f = processed.substring(0,i);
            String s = processed.substring(i,processed.length());
            permutation(f+ch+s,unprocessed.substring(1));
        }

    }

    public static List<String> permutationList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(processed);
            return ans;
        }
        char ch = unprocessed.charAt(0);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i <=processed.length(); i++) {
            String f = processed.substring(0,i);
            String s = processed.substring(i,processed.length());
            List<String> ans = permutationList(f+ch+s,unprocessed.substring(1));
            resultList.addAll(ans);
        }
        return resultList;


    }
}

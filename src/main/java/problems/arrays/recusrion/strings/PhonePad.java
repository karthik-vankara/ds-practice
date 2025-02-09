package problems.arrays.recusrion.strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
//pad("","12");
        System.out.println(padReturn("","12"));
    }
    public static void pad(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        int digit = unProcessed.charAt(0)-'0';
        for (int i = (digit-1)*3; i <digit*3 ; i++) {
            char ch = (char)('a'+i);
            pad(processed+ch,unProcessed.substring(1));
        }

    }

    public static List<String> padReturn(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        int digit = unProcessed.charAt(0)-'0';
        List<String> list = new ArrayList<>();
        for (int i = (digit-1)*3; i <digit*3 ; i++) {
            char ch = (char)('a'+i);
            List<String> out = padReturn(processed+ch,unProcessed.substring(1));
            list.addAll(out);
        }
        return list;

    }
}

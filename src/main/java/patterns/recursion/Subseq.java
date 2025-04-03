package patterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subseq {
    public static void main(String[] args) {
//        subSeq("", "abc");
        System.out.println(subSeqList("", "abc"));
    }

    static void subSeq(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subSeq(processed + ch, unprocessed.substring(1));
        subSeq(processed, unprocessed.substring(1));
    }

    static List<String> subSeqList(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            List<String> list = new ArrayList<>();
            if (!processed.isEmpty())
                list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        List<String> leftList = subSeqList(processed + ch, unprocessed.substring(1));
        List<String> rightList = subSeqList(processed, unprocessed.substring(1));
        leftList.addAll(rightList);
        return leftList;
    }
}

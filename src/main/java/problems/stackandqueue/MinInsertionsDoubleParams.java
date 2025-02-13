package problems.stackandqueue;

public class MinInsertionsDoubleParams {
    public static int minInsertions(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int stackCount = 0;
        int invalidCount = 0;

        s = s.replace("))", "}");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stackCount++;
            } else {
                if (c == ')') {
                    invalidCount++;
                }

                if (stackCount == 0) {
                    invalidCount++;
                } else {
                    stackCount--;
                }
            }
        }
        return invalidCount + stackCount * 2;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("())"));
    }

}

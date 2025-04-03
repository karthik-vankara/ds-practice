package patterns.recursion;

public class Basic {
    public static void main(String[] args) {
        Basic rc = new Basic();
//        System.out.println(rc.skipCharacter("abcdab", 'a'));
        System.out.println(rc.skipCharacterAnother("abcdab", 'a'));
    }

    public String skipCharacter(String str, char ch) {
        return skipCharacterHelper("", str, ch);
    }

    private String skipCharacterHelper(String processed, String unProcessed, char ch) {
        if (unProcessed.length() == 0) {
            return processed;
        }
        char c = unProcessed.charAt(0);
        if (c != ch) {
            processed = processed + c;
        }
        return skipCharacterHelper(processed, unProcessed.substring(1), ch);
    }

    private String skipCharacterAnother(String str, char ch) {
        if (str.isEmpty()) {
            return "";
        }
        char c = str.charAt(0);
        if (c == ch) {
            return skipCharacterAnother(str.substring(1), ch);
        } else {
            return c + skipCharacterAnother(str.substring(1), ch);
        }
    }
}

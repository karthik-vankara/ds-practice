package problems.arrays.recusrion.strings;

public class SkipChar {
    public static void main(String[] args) {
//        skip("baccad","");
        String res = skipReturn("baccddag");
        System.out.println(res);
    }
    public static void skip(String input, String res){
        if(input.isEmpty()){
            System.out.println(res);
            return;
        }
        char ch = input.charAt(0);
        if(ch == 'a'){
            skip(input.substring(1),res);
        }else {
            skip(input.substring(1),res+ch);
        }
    }

    public static String skipReturn(String input){
        if(input.isEmpty()){
            return "";
        }
        char ch = input.charAt(0);
        if(ch == 'a'){
            return skipReturn(input.substring(1));
        }else {
            return ch+ skipReturn(input.substring(1));
        }

    }
}

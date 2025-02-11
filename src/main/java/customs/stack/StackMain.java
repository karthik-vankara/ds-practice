package customs.stack;

public class StackMain {
    public static void main(String[] args) throws Exception {
//        CustomStack stack = new CustomStack(5);
        CustomStack stack = new DynamicStack();
//        stack.push(10);
//        stack.push(20);
        for (int i = 1; i <= 20; i++) {
            stack.push(i*10);
        }
        System.out.println(stack.pop());
    }
}

package problems.stackandqueue;

import java.util.Stack;

class QwithStack {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public QwithStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        while (!st1.empty()){
            st2.push(st1.pop());
        }

        int popedVal = (int)st2.pop();

        while (!st2.empty()){
            st1.push(st2.pop());
        }
        return popedVal;
    }

    public int peek() {
        while (!st1.empty()){
            st2.push(st1.pop());
        }

        int peekVal = (int)st2.peek();

        while (!st2.empty()){
            st1.push(st2.pop());
        }
        return peekVal;
    }

    public boolean empty() {
        return st1.empty();
    }


    public static void main(String[] args) {
        QwithStack qwithStack = new QwithStack();
        qwithStack.push(1);
        qwithStack.push(2);
        System.out.println(qwithStack.peek());
        System.out.println(qwithStack.pop());
        System.out.println(qwithStack.empty());
    }
}



/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

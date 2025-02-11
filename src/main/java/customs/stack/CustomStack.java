package customs.stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    
    private int indexPointer = -1;

    public CustomStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }
    
    public boolean push(int item) throws CustomStackException {
        if(isFull()){
            throw new CustomStackException("Stack is full");
        }
        indexPointer++;
        data[indexPointer] = item;
        return true;
    }

    public boolean isFull() {
        return this.indexPointer == data.length-1;
    }
    public boolean isEmpty() {
        return this.indexPointer == -1;
    }
    public int pop() throws CustomStackException {
        if(isEmpty()){
            throw new CustomStackException("No items to pop");
        }
        return data[indexPointer--];
    }
    public int peek() throws CustomStackException {
        if(isEmpty()){
            throw new CustomStackException("No items to peek");
        }
        return data[indexPointer];
    }

}

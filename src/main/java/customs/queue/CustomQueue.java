package customs.queue;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    public CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    int end = 0;

    public boolean isFull(){
        return data.length == end;
    }
    public boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is full to insert");
            return false;
        }
        data[end++] = item;
        return true;
    }
    public int delete(){
        if(isEmpty()){
            System.out.println("Queue is empty to delete");
            return -1;
        }
        int deleted = data[0];

        for (int i = 0; i <data.length-1 ; i++) {
            data[i] = data[i+1];
        }
        end--;
        return deleted;
    }
}

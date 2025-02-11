package customs.queue;

public class QueueMain {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        for (int i = 1; i < 5; i++) {
            queue.insert(i*10);
        }
        System.out.println(queue.delete());
    }
}

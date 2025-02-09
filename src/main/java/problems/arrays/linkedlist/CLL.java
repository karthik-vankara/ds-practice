package problems.arrays.linkedlist;

public class CLL {
    private Node head;
    private Node tail;

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void delete(int value){
        Node node  = head;
        if(node == null){
            return;
        }
        if(node.value == value){
            head = head.next;
            tail = head;
        }
        do{
            Node n = node.next;
            if(n.value == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node != head);
    }

    public void display(){
        Node node = head;
        if(head != null){
            do{
                System.out.print(node.value +" ->");
                node = node.next;
            }while (node != head);
        }
    }
}

package problems.arrays.linkedlist;

public class DLL {
    Node head;
    private int size;

    private class Node{
        private int value;
        private Node prev;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int value){
        Node node = new Node(value);
        node.next = null;

        Node lastNode = null;
        Node temp = head;
        while (temp != null){
            lastNode = temp;
            temp = temp.next;
        }
        if(lastNode == null){
            insertFirst(value);
        }else{
            node.prev = lastNode;
            lastNode.next = node;
            size++;
        }
    }

    public void insertAfterValue(int after, int value){
        Node indexNode = null;
        Node temp = head;
        while (temp != null){
            if(temp.value == after){
                indexNode = temp;
            }
            temp = temp.next;
        }
        if(indexNode == null){
            insertLast(value);
            return;
        }
        Node node = new Node(value);
        node.prev = indexNode;
        node.next = indexNode.next;
        indexNode.next = node;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public void displayReverse(){
        Node temp = head;
        Node lastNode = null;
        while (temp!=null){
            lastNode =temp;
            temp = temp.next;
        }
        while (lastNode!=null){
            System.out.print(lastNode.value+" -> ");
            lastNode = lastNode.prev;
        }
        System.out.print("START");
        System.out.println();
    }
}

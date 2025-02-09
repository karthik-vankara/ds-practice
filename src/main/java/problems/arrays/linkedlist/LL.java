package problems.arrays.linkedlist;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size=0;
    }

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

    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(tail ==  null){
            tail = head;
        }
        size +=1;
    }

    public void insertLast(int data){
        if(tail == null){
            insertFirst(data);
        }else {
            Node node = new Node(data);
            tail.next = node;
            tail = node;
            size +=1;
        }
    }

    public void insert(int data, int index){
        if(index == 0){
            insertFirst(data);
            return;
        }
        if(index == size){
            insertLast(data);
            return;
        }
        Node temp =  head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size +=1;
    }

    public int deleteFirst(){
        if(head == null){
            tail = null;
            return -1;
        }
        int val =head.value;
        head = head.next;
        size--;
        return val;
    }
    public int deleteLast(){
        if(size <=1){
            deleteFirst();
        }
        Node secondLast = getNode(size-2);
        int val = secondLast.next.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            deleteFirst();
        }
        if(index == size-1){
            deleteLast();
        }
        Node prev = getNode(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node getNode(int index){
        Node node = head;
        for (int i = 1; i <=index ; i++) {
            node = node.next;
        }
        return node;
    }

    public Node getNodeByValue(int value){
        Node node = head;
        while (node!=null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertRecursion(int value, int index){
         head = insertRecursion(value,index,head);
    }

    private Node insertRecursion(int value, int index, Node node) {
        if(index == 0){
            Node newNode = new Node(value,node);
            size++;
            return newNode;
        }
        node.next = insertRecursion(value,index-1,node.next);
        return node;
    }


    public void display(){
//            If i use head, it will change the obj ref, so we are using temp variable
//            y=temp will keep on change
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value +" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public int length(){
        return this.size;
    }



//    Questions
    public void deleteDuplicates(){
        Node node = head;
        while (node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public static LL mergeTwolists(LL first,LL second){
        Node f = first.head;
        Node s = second.head;

        LL res = new LL();

        while (f!= null && s!= null){
            if(f.value < s.value){
                res.insertLast(f.value);
                f = f.next;
            }else{
                res.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null){
            res.insertLast(f.value);
            f = f.next;
        }
        while (s != null){
            res.insertLast(s.value);
            s = s.next;
        }
        return res;
    }


    public void reverseRecursion(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverseRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next =  null;

    }

    public void reverseIteration(Node node){
//        if(size <2){
//            return;
//        }
        Node prev = null;
        Node pres = node;
        Node next = node.next;

        while (pres != null){
            pres.next = prev;
            prev  = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }


    public static void main(String[] args) {
//        LL first = new LL();
//        LL second = new LL();
//
//        first.insertLast(1);
//        first.insertLast(3);
//        first.insertLast(5);
//
//        second.insertLast(1);
//        second.insertLast(2);
//        second.insertLast(9);
//        second.insertLast(14);
//
//        LL ans = LL.mergeTwolists(first,second);
//        ans.display();

        LL list = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
//        list.reverseRecursion(list.head);
        list.reverseIteration(list.head);
        list.display();
    }
}

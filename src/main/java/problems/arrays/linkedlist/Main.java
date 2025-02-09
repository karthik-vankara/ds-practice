package problems.arrays.linkedlist;


public class Main {
    public static void main(String[] args) {
        LL linkedList = new LL();
        linkedList.insertFirst(10);
        linkedList.insertLast(10);
        linkedList.insertLast(30);
        linkedList.insertLast(30);
        linkedList.insertLast(60);
//        linkedList.insert(40,3);
        linkedList.display();
//        System.out.println("length:: "+linkedList.length());
//        System.out.println("deleted first"+linkedList.deleteFirst());
//        linkedList.display();
//        System.out.println("length:: "+linkedList.length());
//        System.out.println("deleted last"+linkedList.deleteLast());
//        linkedList.display();
//        System.out.println("length:: "+linkedList.length());
//        System.out.println("delete at index:: "+linkedList.delete(2));
//        linkedList.display();
//        System.out.println("length:: "+linkedList.length());

//        linkedList.insertRecursion(35,2);
//        linkedList.display();

//        DLL list = new DLL();
//        list.insertFirst(20);
//        list.insertFirst(10);
//        list.display();
//        list.displayReverse();
//        list.insertLast(30);
//        list.display();
//        list.insertAfterValue(30,40);
//        list.display();

//        CLL list = new CLL();
//        list.insert(10);
//        list.insert(20);
//        list.insert(30);
//        list.insert(40);
//        list.display();


//        Questions
        linkedList.deleteDuplicates();
        linkedList.display();

    }
}

package patterns;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        ListNode current = this; // Start from the current node
//
//        while (current != null) {
//            sb.append(current.val);
//            if (current.next != null) {
//                sb.append(" -> "); // Add an arrow if there's a next node
//            }
//            current = current.next;
//        }
//
//        return sb.toString();
//    }

}

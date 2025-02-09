package problems.arrays.linkedlist;

public class MergeSort {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    //    copied from LL
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode tail = head;


        ListNode f = list1;
        ListNode s = list2;

        while (f != null && s != null) {
            if (f.val < s.val) {
                tail.next = new ListNode(f.val);
                f = f.next;
            } else {
                tail.next = new ListNode(s.val);
                s = s.next;
            }
            tail = tail.next;
        }
        while (f != null) {
            tail.next = new ListNode(f.val);
            f = f.next;
            tail = tail.next;
        }
        while (s != null) {
            tail.next = new ListNode(s.val);
            s = s.next;
            tail = tail.next;
        }
        return head.next;
    }

    //    Copied from cycle problems (slow pointer and fast poiinter)
//    Thos will work only to get middle but for merge sort we need to break the halfs
//    public ListNode middleNode(ListNode head) {
//        ListNode fP = head;
//        ListNode sP = head;
//        while (fP != null && fP.next != null) {
//            fP = fP.next.next;
//            sP = sP.next;
//        }
//        return sP;
//    }

    public ListNode middleNode(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}

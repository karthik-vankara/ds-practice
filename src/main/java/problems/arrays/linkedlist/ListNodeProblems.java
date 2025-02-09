package problems.arrays.linkedlist;

import org.w3c.dom.Node;

public class ListNodeProblems {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseIteration(ListNode node) {

        if (node == null) {
            return node;
        }
        ListNode prev = null;
        ListNode present = node;
        ListNode next = node.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

//        reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode firstHalf = head;
        ListNode mid = getMiddleNode(head);
        ListNode secondHalf = reverseIteration(mid);
        ListNode reversedHead = secondHalf;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        reverseIteration(reversedHead);
        return firstHalf == null || secondHalf == null;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMiddleNode(head);
        ListNode headFirst = head;
        ListNode headSecond = reverseIteration(mid);
        while (headFirst != null && headSecond != null){
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            ListNode temp1 = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp1;
        }
        if(headFirst != null){
            headFirst.next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        int i=1;
        while (i<=k){
            ListNode prev = null;
            ListNode tempHead = head;
            ListNode headNext = head.next;

            while (tempHead != null){
                prev = tempHead;
                tempHead = tempHead.next;
            }
            tempHead.next = headNext;
            prev.next = null;

        }
        return head;
    }
}

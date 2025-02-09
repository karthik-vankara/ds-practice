package problems.arrays.linkedlist;

public class CycleProblems {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public int cycleLength(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int length = 0;
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while (temp != fast);
                return length;
            }
        }
        return 0;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        int cycleLength = 0;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                cycleLength = cycleLength(head);
                break;
            }
        }
        if(cycleLength > 0){
            ListNode first = head;
            ListNode second = head;

//            move second pointer by cycle length times
            while (cycleLength >0){
                second = second.next;
                cycleLength--;
            }
//            move both first and second pointers by 1 so they meet at start of cycle
            while (first != second){
                first = first.next;
                second = second.next;
            }
            return first;
        }else{
            return null;
        }

    }


    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;

//        int slowSquare = getSquare(slow);
//        int fastSquare = getSquare(fast);
//
//        while (fastSquare != 1){
//            slowSquare = getSquare(slowSquare);
//            fastSquare = getSquare(getSquare(fastSquare));
//
//            if(fastSquare == slowSquare){
//                return false;
//            }
//        }
//        return true;
        do{
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        }while (slow != fast);
        if(slow == 1){
            return true;
        }
        return false;
    }

    public static int getSquare(int num){
        int ans = 0;
        while (num >0){
            int rem = num%10;
            ans += rem*rem;
            num = num/10;
        }
        return ans;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fP = head;
        ListNode sP = head;
        while (fP != null && fP.next != null){
            fP = fP.next.next;
            sP = sP.next;
        }
        return sP;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
    }

}

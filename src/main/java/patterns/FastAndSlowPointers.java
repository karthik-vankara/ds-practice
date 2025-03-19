package patterns;

import java.util.HashMap;

public class FastAndSlowPointers {
    public static void main(String[] args) {
        FastAndSlowPointers fsp = new FastAndSlowPointers();
//        System.out.println(fsp.hasCycle(fsp.getTestListNode()));

//        System.out.println(fsp.getCycleLength(fsp.getTestListNode()));

//        System.out.println(fsp.detectCycle(fsp.getTestListNode()).val);
//        System.out.println(fsp.middleNode(fsp.getTestListNode()).val);

//        ListNode l = fsp.getTestListNode();
//        ListNode reverse = fsp.reverse(l);
//        fsp.displayLinkedList(reverse);

//        System.out.println(fsp.isPalindrome(fsp.getTestListNode()));
//        System.out.println(fsp.isHappy(19));
//        System.out.println(fsp.findDuplicate(new int[]{3, 1, 3, 4, 2}));
//        System.out.println(fsp.pairSum(fsp.getTestListNode()));

//        ListNode partition = fsp.partition(fsp.getTestListNode(), 3);
//        fsp.displayLinkedList(partition);

        ListNode reorderNode = fsp.getTestListNode();
        fsp.reorderList(reorderNode);
        fsp.displayLinkedList(reorderNode);
    }

    public boolean hasCycle(ListNode head) {
//        displayLinkedList(head);
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
//          Cycle found, assign slow to head and move both slw and fast pointer by 1
//          If both pointers meet then its the staring point;
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public boolean isPalindrome(ListNode head) {

//        Bruteforce O(N^2)
//        if (head == null) {
//            return false;
//        }
//        int listSize = getSize(head);
//        if (listSize == 1) {
//            return true;
//        }
//        int left = 1;
//        int right = listSize;
//
//        while (left <= right) {
//            ListNode leftNode = getNodeAtIndex(head, left);
//            ListNode rightNode = getNodeAtIndex(head, right);
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;


//        step1: get middle Node
        ListNode middle = middleNode(head);
//        step2: reverse from middle node
        ListNode middleReverse = reverse(middle);

//        compare firsthalf with secondHalf and go on till secondHalf reaches null
        ListNode firstHalf = head;
        ListNode secondHalf = middleReverse;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;

    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;

    }

    private int getSquareSum(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num = num / 10;
        }
        return ans;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public int findDuplicate(int[] nums) {

//        additional space
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int res = -1;
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            if (map.get(nums[i]) > 1) {
//                res = nums[i];
//                break;
//            }
//        }
//        return res;


        int slow = 0, fast = 0;
//      detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
//      now cycle is at fast

//        Move slow by 1 and fast by 1, will reach to start of cycle
        slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);

        if (slow == fast) {
            return slow;
        } else return -1;
    }

    //    maximum pair sum of a linkedlist
    public int pairSum(ListNode head) {

        ListNode firstHalf = head;
        ListNode middle = middleNode(head);
        ListNode secondHalf = reverse(middle);

        int maxSum = 0;

        while (secondHalf != null) {
            int sum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(sum, maxSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

    //    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//    You should preserve the original relative order of the nodes in each of the two partitions.
    public ListNode partition(ListNode head, int x) {

//        step1: create 2 lists names left list and right list
//        leftlist = nodes < x;
//        rightlist = nodes > x;

//        leftlist.last = rightlist (merge both lists) (make sure right.last is null)
//        return left

        ListNode leftList = new ListNode(), rightList = new ListNode();
        ListNode leftTail = leftList, rightTail = rightList;

        while (head != null) {
//            add elements to left
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = rightList.next;
        return leftList.next;

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = middleNode(head);
        ListNode reversedMiddle = reverse(middle);

        ListNode firstHalf = head;
        ListNode secondHalf = reversedMiddle;

        while (firstHalf != null && secondHalf != null) {
            ListNode temp = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = temp;

            ListNode temp1 = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = temp1;
        }

        // next of tail to null
        if (firstHalf != null) {
            firstHalf.next = null;
        }

    }


//    Helper functions

    public int getCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode tempSlow = slow;
                ListNode tempFast = fast.next;
                do {
                    length++;
                    tempSlow = tempFast.next;
                    tempFast = tempFast.next.next;
                } while (tempSlow != slow);
                break;
            }
        }
        return length;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, current = head, next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void displayLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public int getSize(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    private ListNode getNodeAtIndex(ListNode head, int index) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            if (index == size) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode getTestListNode() {
        ListNode head = new ListNode(1);
        ListNode cycleNode = new ListNode(2);
        head.next = cycleNode;
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
//        creating a cycle
//        head.next.next.next.next = cycleNode;
        return head;
    }
}

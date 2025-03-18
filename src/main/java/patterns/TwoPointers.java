package patterns;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers twoPointers = new TwoPointers();
//        System.out.println(Arrays.toString(twoPointers.twoSum(new int[]{2,3,4}, 5)));
//        System.out.println(twoPointers.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(twoPointers.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(twoPointers.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(twoPointers.removeNthFromEnd(twoPointers.getTestListNode(), 2));

//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
//        twoPointers.merge(nums1, 3, nums2, 3);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums = {2, 0, 2, 1, 1, 0};
//        twoPointers.sortColors(nums);
//        System.out.println(Arrays.toString(nums));

//        System.out.println(twoPointers.numSubarrayProductLessThanK(new int[]{10,5,2,6},100));

        System.out.println(twoPointers.lengthOfLongestSubstring("pwwkew"));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                res[0] = ++start;
                res[1] = ++end;
                break;
            } else if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {

//        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
//        Matcher matcher = pattern.matcher(s);
//        String cleanedString = matcher.replaceAll("").toLowerCase();
//        int start=0,end=cleanedString.length()-1;
//        while (start <= end){
//            int sChar = cleanedString.charAt(start);
//            int eChar = cleanedString.charAt(end);
//            if(sChar != eChar){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;

        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(ch);
            }
        }
        String cleanedString = builder.toString().toLowerCase();
        System.out.println(cleanedString);
        String reverse = builder.reverse().toString().toLowerCase();
        return cleanedString.equals(reverse);

    }

    //    Container with most water
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    List<Integer> list = List.of(nums[i], nums[start], nums[end]);
                    res.add(list);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
            }
        }
        return res;
    }


    //     Fast and slow pointer
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

//         Move fast and slow till fast reacheds end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        displayLinkedList(dummy.next);
        return dummy.next;
    }

    //    Fast and Slow Pointer
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 & p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[lastIndex] = nums2[p2];
                p2--;
            } else {
                nums1[lastIndex] = nums1[p1];
                p1--;
            }
            lastIndex--;
        }
        while (p2 > 0) {
            nums1[lastIndex] = nums2[p2];
            p2--;
            lastIndex--;
        }
    }

    // Dutch flag algorithm
    // [0 -> low-1] -> 0
    // [low -> mid-1] -> 1
    // [high+1 -> n-1] ->2
    // 3 pointer
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    //    Sub array product < k
    //    return no of subarrays where len < k
//    nums = [10,5,2,6], k = 100
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int subArrayCount = 0, left = 0, right = 0, windowProduct = 1;
        while (right < nums.length) {
            windowProduct *= nums[right];
            if (left <= right && windowProduct >= k) {
                windowProduct = windowProduct / nums[left];
                left++;
            }
            subArrayCount += right - left + 1;
            right++;
        }
        return subArrayCount;
    }

    public int lengthOfLongestSubstring(String str) {
        int maxLen = 0;
        int left = 0, right = 0;
        int[] hash = new int[256];

        while (right < str.length()){
            int rightCh = str.charAt(right);
            hash[rightCh]++;

            while (hash[rightCh] > 1){
                int leftCh = str.charAt(left);
                hash[leftCh]--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }


    //    Helpers method for all problems
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public ListNode getTestListNode() {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        return head;
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
}

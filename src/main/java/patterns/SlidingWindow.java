package patterns;

import java.lang.reflect.Array;
import java.util.*;

//    Sliding window
//    expand and shrink (window starts from zero)
public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
//        System.out.println(slidingWindow.maxSumSubArray(new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20},4));
//        System.out.println(slidingWindow.longestSubstringLengthWithOutRepeatingChars("abcabcbb"));
//        System.out.println(slidingWindow.longestUniqueSubstring("abcabcbb"));
//        System.out.println(slidingWindow.minWindow("ddaaabbca","abc"));
//        System.out.println(slidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
//        System.out.println(slidingWindow.findAnagrams("abab", "ab"));
        System.out.println(slidingWindow.findAnagramsOptimised("baa", "aa"));
    }

    //Given an array of integers and an integer k, find the maximum sum of any contiguous subarray of size k.
    //Constant window
    public int maxSumSubArray(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) {
            return -1;
        }
        int left = 0, right = k - 1;
        int maxSum = Integer.MIN_VALUE, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        while (right < arr.length - 1) {
            windowSum -= arr[left];
            left++;
            right++;
            windowSum += arr[right];
            maxSum = Math.max(windowSum, maxSum);
        }
//        To print the indexes
        System.out.println("indexes" + left + "," + right);
        return maxSum;
    }


    public int longestSubstringLengthWithOutRepeatingChars(String str) {

//Bruteforce - O(N^2)

//        int maxLength = 0;
//        for (int i = 0; i < str.length(); i++) {
//            int[] hash = new int[256];
//            int length = 0;
//            for (int j = i; j < str.length() ; j++) {
//                if(hash[(int)str.charAt(j)] == 1){
//                    break;
//                }
//                length = j-i+1;
//                maxLength = Math.max(length,maxLength);
//                hash[(int)str.charAt(j)] = 1;
//            }
//        }
//        return maxLength;

        int left = 0, right = 0;
        int length = 0, maxLength = 0;

        int[] hash = new int[256];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }
        while (right < str.length()) {
            if (hash[(int) str.charAt(right)] != -1) {
                if (hash[(int) str.charAt(right)] >= left) {
                    left = hash[(int) str.charAt(right)] + 1;
                }
            }
            length = right - left + 1;
            maxLength = Math.max(length, maxLength);
            hash[(int) str.charAt(right)] = right;
            right++;
        }

        return maxLength;
    }

    public String longestUniqueSubstring(String str) {
        int maxLength = 0, startIndex = 0;
        int left = 0, right = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while (right < str.length()) {
            char ch = str.charAt(right);
            if (hash[ch] != -1 && hash[ch] >= left) {
                left = hash[ch] + 1;
            }
            hash[ch] = right;

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
            right++;
        }
        return str.substring(startIndex, startIndex + maxLength);

    }

    public String minWindow(String str, String t) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;
        int n = str.length(), m = t.length();

        int[] hash = new int[256];
//        preinsertion
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while (right < n) {
            int chRight = str.charAt(right);
            if (hash[chRight] > 0) {
                count++;
            }
            hash[chRight]--;
            while (count == m) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }
                int chLeft = str.charAt(left);
                if (hash[chLeft] == 0) {
                    count--;
                }
                hash[chLeft]++;
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : str.substring(startIndex, startIndex + minLength);

    }

    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int left = 0, right = 0;
        int maxLength = 0, maxFreq = 0;
        while (right < s.length()) {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;  // Shrink window
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Stores indices, not values
        int left = 0, right = 0;

        while (right < nums.length) {
            // Remove smaller values from deque (maintain decreasing order)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right); // Add current index to deque

            // Remove elements that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // Add max value to result once we have a valid window
            if (right >= k - 1) {
                res.add(nums[deque.peekFirst()]);
                left++; // Slide the window
            }
            right++;
        }

        // Convert List<Integer> to int[]
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    //    Maximum contigious subarray with 2 unique elements
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if (map.size() > 2) {
//                while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
//                }
            }
            if (map.size() <= 2) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    //    Permutation in string
    public boolean checkInclusion(String s1, String s2) {

        int[] chHash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chHash[s1.charAt(i) - 'a']++;
        }

        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            int windowIdx = 0, idx = i;
            int[] windowHash = new int[26];

            while (windowIdx < windowSize && idx < s2.length()) {
                windowHash[s2.charAt(idx) - 'a']++;
                windowIdx++;
                idx++;
            }
            if (isFrequencySame(chHash, windowHash)) {
                return true;
            }

        }
        return false;
    }

    private boolean isFrequencySame(int[] chHash, int[] windowHash) {
        for (int i = 0; i < chHash.length; i++) {
            if (chHash[i] != windowHash[i]) {
                return false;
            }
        }
        return true;
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = 0, left = 0, right = 0, product = 1;
        while (right < nums.length) {
            product = product * nums[right];
            while (left <= right && product >= k) {
                product = product / nums[left];
                left++;
            }
            len += right - left + 1;
            right++;
        }
        return len;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }

//       O(26*N)
        int[] fre = new int[26];
        for (int i = 0; i < p.length(); i++) {
            fre[p.charAt(i) - 'a']++;
        }

        int leftLast = s.length() - p.length();
        for (int left = 0; left <= leftLast; left++) {
            int[] windowHash = new int[26];
            for (int right = left; right < left + p.length(); right++) {
                windowHash[s.charAt(right) - 'a']++;
            }
            if (isFrequencySame(fre, windowHash)) {
                res.add(left);
            }
        }
        return res;
    }

    public List<Integer> findAnagramsOptimised(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        int[] freq = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0, right = 0, matches = 0;

        while (right < s.length()) {
            char addChar = s.charAt(right);
            window[addChar - 'a']++;

            if (window[addChar - 'a'] <= freq[addChar - 'a']) {
                matches++;
            }

            if (right - left + 1 > p.length()) {
                char removeChar = s.charAt(left);
                if (window[removeChar - 'a'] <= freq[removeChar - 'a']) {
                    matches--;
                }
                window[removeChar - 'a']--;
                left++;
            }

            if (matches == p.length()) {
                res.add(left);
            }

            right++;
        }

        return res;
    }

}

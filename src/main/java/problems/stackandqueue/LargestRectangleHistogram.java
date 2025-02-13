package problems.stackandqueue;

import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,5,2};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = prevSmallerElement(heights, n);
        int[] nextSmaller = nextSmallerElement(heights, n);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (nextSmaller[i] - prevSmaller[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static int[] prevSmallerElement(int[] heights, int n) {
        Stack<Integer> s = new Stack<>();
        int[] prevSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            prevSmaller[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return prevSmaller;
    }

    public static int[] nextSmallerElement(int[] heights, int n) {
        Stack<Integer> s = new Stack<>();
        int[] nextSmaller = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            nextSmaller[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        return nextSmaller;
    }
}

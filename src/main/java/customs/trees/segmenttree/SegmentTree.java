package customs.trees.segmenttree;

import java.util.concurrent.RecursiveTask;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.querySum(2, 6));
    }

    public static class Node {
        int data;
        Node left;
        Node right;
        int leftIndex;
        int rightIndex;

        public Node(int leftIndex, int rightIndex) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        public Node(int data, int leftIndex, int rightIndex) {
            this.data = data;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    ", leftIndex=" + leftIndex +
                    ", rightIndex=" + rightIndex +
                    '}';
        }
    }

    private Node root;


    public SegmentTree(int[] arr) {
        this.root = constructSegmentTree(arr, 0, arr.length - 1);
    }

    private Node constructSegmentTree(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            Node leaf = new Node(startIndex, endIndex);
            leaf.data = arr[startIndex];
            return leaf;
        }
        Node node = new Node(startIndex, endIndex);
        int mid = (startIndex + endIndex) / 2;
        node.left = constructSegmentTree(arr, startIndex, mid);
        node.right = constructSegmentTree(arr, mid + 1, endIndex);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str += "leftIndex[" + node.left.leftIndex + "," + node.left.rightIndex + "]" + "|| data->" + node.left.data;
        }
        str += "leftIndex[" + node.left.leftIndex + "," + node.right.rightIndex + "]" + "|| data->" + node.data;
        if (node.right != null) {
            str += "rightIndex[" + node.right.leftIndex + "," + node.right.rightIndex + "]" + "|| data->" + node.right.data;
        }
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int querySum(int start, int end) {
        return querySum(this.root, start, end);
    }

    private int querySum(Node node, int start, int end) {
        if (node.leftIndex >= start && node.rightIndex <= end) {
//            node is completely inside query
            return node.data;
        } else if (node.leftIndex > end || node.rightIndex < start) {
//            node is outside query
            return 0;
        } else {
            return querySum(node.left, start, end) + querySum(node.right, start, end);
        }
    }

    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.leftIndex && index <= node.rightIndex) {
            if (index == node.leftIndex && index == node.rightIndex) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}

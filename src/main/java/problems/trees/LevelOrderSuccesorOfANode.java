package problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderSuccesorOfANode {
    public static void main(String[] args) {

    }

    // BFS
//    If you find the element an the level return the next element(i.e succesor) getNextNodeOfGiven
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean itemFound = false;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.val == key) {
                    itemFound = true;
                    break;
                }
            }
            if (itemFound) {
                break;
            }
        }
        return queue.peek();
    }

    //    Same code as above optimized
    public TreeNode findSuccessorOptimized(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}

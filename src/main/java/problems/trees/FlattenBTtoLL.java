package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBTtoLL {
    public static void main(String[] args) {

    }
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        TreeNode tempRoot = queue.poll();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            tempRoot.left = null;
            tempRoot.right = node;
            tempRoot = node;
        }
    }
    public void preOrder(TreeNode node) {
        if(node == null){
            return;
        }
        queue.offer(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void flattenOptimised(TreeNode root) {
        TreeNode current = root;
        while (current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }


}

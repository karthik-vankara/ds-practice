package problems.trees;

import customs.trees.binarytree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementBST {
    public static void main(String[] args) {

    }
    List<Integer> data = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return data.get(k-1);
    }

    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        data.add(node.val);
        inOrder(node.right);
    }
}

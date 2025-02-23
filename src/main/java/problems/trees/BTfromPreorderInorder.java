package problems.trees;

import java.util.Arrays;

public class BTfromPreorderInorder {
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),
                Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),
                Arrays.copyOfRange(inorder,index+1,inorder.length));

        return node;
    }
}

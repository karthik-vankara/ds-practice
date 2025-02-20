package problems.trees;

public class DiameterOfTree {
    public static void main(String[] args) {

    }

    int diameterMax=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameterMax-1;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight+rightHeight+1;
        diameterMax = Math.max(dia,diameterMax);

        return Math.max(leftHeight,rightHeight)+1;
    }
}

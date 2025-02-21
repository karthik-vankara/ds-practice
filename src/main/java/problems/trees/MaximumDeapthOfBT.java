package problems.trees;

public class MaximumDeapthOfBT {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root ==  null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int deapth =Math.max(left,right)+1;
        return deapth;
    }
}
